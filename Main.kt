/*
* Herança:
*
* Superclasse / Classe Base (Classe Pai/ Classe Mãe)
* Subclasse / Classe Derivada (Classe Filha)
* - São as classes quee herdam atributos e/ ou métodos
* */

// Classe base
open class Animal(val name:String){
    open fun makeSound(){
        print("The animal makes a sound ")
    }
}

// classe Derivada

class Cat(name: String) : Animal(name){
    override fun makeSound(){
        println("A gata $name Molina mia: MIAU MIAU")
    }
}

class Parrot(name: String): Animal(name){
    override fun makeSound() {
        println("The parrot $name makes the sound: curupaco paco")

    }
}

fun main() {
    val cat = Cat("Shakira")
    val parrot = Parrot("Michael Jackson")
    cat.makeSound()
    parrot.makeSound()

    }
