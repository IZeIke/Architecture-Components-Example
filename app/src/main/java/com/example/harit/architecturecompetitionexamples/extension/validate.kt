package com.example.harit.architecturecompetitionexamples.extension

fun String.checkUsername() : Boolean{
    if(this.length > 6){
        if(this.matches("[a-zA-Z0-9 ]*".toRegex())) {
            return true
        }
    }
    return false
}

fun String.checkPassword() : Boolean{
    if(this.length > 8){
        if(this.matches("[a-zA-Z0-9 ]*".toRegex())) {
            return true
        }
    }
    return false
}

fun String.checkName() : Boolean{
    if(this.matches("[a-zA-Z0-9 ]*".toRegex())){
        return true
    }
    return false
}