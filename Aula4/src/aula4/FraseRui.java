/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula4;

/**
 *
 * @author dlavareda
 */
public class FraseRui {
    public static void main(String[] args) {
		
		int totalSemEspacos=0;
		int[] ateTeApagas = new int[26] ; 
		
		String str = "Wellcome to Java!".toLowerCase();
		int total = str.length();
		
		for ( int i=0 ; i < str.length(); i++  ) {
			if ( str.charAt(i) != ' ' ) 
				totalSemEspacos++;
			if( ( str.charAt(i) >= 'a' && str.charAt(i) <= 'z' ) )
				ateTeApagas[ str.charAt(i)-'a' ]++;
		}
		
		System.out.println( "Numero de caracteres é " + total );
		System.out.println( "Numero de caracteres sem espaços é " + totalSemEspacos );
		System.out.println( "Numero de palavras é " + ( total - totalSemEspacos + 1 ) );
		
		for ( int i = 0; i < ateTeApagas.length ; i++ ) {
			System.out.println( (char)( i +'a') + ": " + ateTeApagas[ i ] );
		}
	}
}
