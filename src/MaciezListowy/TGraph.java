package MaciezListowy;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 * @author Admin
 */
public class TGraph extends AGraph {

    private int[][] matrix;

    public TGraph(int vertexCount) {
        super(vertexCount);
        matrix = new int[vertexCount][vertexCount];

    }

    @Override
    public void writeMatrix() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public boolean check(int i, int j) throws IllegalArgumentException {
        try {
            return matrix[i][j] == 1;
        } catch (Exception e) {
            throw new IllegalArgumentException("Liczba spoza tablicy!");
        }
    }

    @Override
    public void connect(int i, int j) throws IllegalArgumentException {

        try {
            matrix[i][j] = 1;
        } catch (Exception e) {
            throw new IllegalArgumentException("Liczba spoza tablicy!");
        }
    }

    @Override
    public void writeList() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 1) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    public void bezSasiadow() {
        for (int i = 0; i < size; i++) {
            boolean nieMa = true;
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 1) {
                    nieMa = false;
                }
            }
            if (nieMa) {
                System.out.print(i + " ");
            }

        }

    }

    public boolean isNieskierowany() {

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 1 && matrix[j][i] == 1) {
                    return false;
                }
            }

        }
        return true;

    }

    public boolean hasPathDFS(int source, int destination) {

        Deque<Integer> kolekcja = new ArrayDeque<>();
        HashSet<Integer> visited = new HashSet<>();
        kolekcja.add(source);

        return hasPathDFS(destination, kolekcja, visited);


    }

    public boolean hasPathBFS(int source, int destination) {

        Queue<Integer> kolekcja = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        kolekcja.add(source);

        return hasPathBFS(destination, kolekcja, visited);


    }

    private boolean hasPathBFS(int destination, Queue<Integer> kolekcja, HashSet<Integer> visited) {
        if (kolekcja.isEmpty()) {
            System.out.println("koniec stosu");
            return false;
        }

        int source = kolekcja.remove();
        if (visited.contains(source)) {
            System.out.println("klocek był juz odwiedzony");
            return false;
        }
        visited.add(source);
        System.out.println("przeszukuje " + source);
        if (matrix[source][destination] == 1) {
            System.out.println("znalazłem połaczenie do " + destination);
            return true;
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[source][i] == 1 && !visited.contains(i)) kolekcja.add(i);


        }

        return hasPathBFS(destination, kolekcja, visited);


    }


    private boolean hasPathDFS(int destination, Deque<Integer> kolekcja, HashSet<Integer> visited) {
        if(!kolekcja.isEmpty()) System.out.println("Przeszukuje klocek "+kolekcja.peek());
        if (kolekcja.isEmpty()){
            System.out.println("koniec stosu");
            return false;
        }
        int source = kolekcja.pop();
        if (visited.contains(source)){
            System.out.println("klocek był juz odwiedzony");
            return false;
        }
        visited.add(source);

        if (matrix[source][destination] == 1) {
            System.out.println("znalazłem połaczenie do " + destination);
            return true;

        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[source][i] == 1&&!visited.contains(i)) kolekcja.push(i);


        }
        visited.add(source);
        return hasPathDFS(destination, kolekcja, visited);

    }


}










