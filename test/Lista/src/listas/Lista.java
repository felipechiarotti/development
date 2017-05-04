package listas;
import listas.les.*;
import listas.binary.*;
import java.io.*;
public class Lista{
	public static void main(String[] args) {
		BST lista = new BST();
		BinaryAccount acc = new BinaryAccount(5);
		lista.insert(acc);
		lista.insert(new BinaryAccount(8));
		lista.insert(new BinaryAccount(3));
		lista.insert(new BinaryAccount(4));
		lista.insert(new BinaryAccount(12));
		lista.insert(new BinaryAccount(23));
		lista.delete(acc);
		System.out.println(lista);
	}
}