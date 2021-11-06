/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package br.ufg.inf.oop.internshipcandidatefinder.exceptions;

/**
 *
 * @author karlos
 */
public class InvalidInputFromUserException extends Exception {

    /**
     * Creates a new instance of <code>InvalidInputFromUserException</code>
     * without detail message.
     */
    public InvalidInputFromUserException() {
    }

    /**
     * Constructs an instance of <code>InvalidInputFromUserException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidInputFromUserException(String msg) {
        super(msg);
    }
}
