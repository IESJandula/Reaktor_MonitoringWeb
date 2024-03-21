require 'rest-client'
require 'json'
class MainController < ApplicationController
    def inicio
        urlRedes = "http://localhost:8080/net/get/all/data"
        begin
            responseRedes = RestClient.get(
                urlRedes
            ) 
            @redes  = JSON.parse(responseRedes.body)
            puts @redes
            puts responseRedes.code
        rescue RestClient::ExceptionWithResponse => e
            puts "Error: #{e.response}"
        end
    end
end