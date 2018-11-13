package MaciezListowy;

import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class LGraph extends AGraph {

    private List<List<Integer>> list;

    public LGraph(int vertexCount) {
        super(vertexCount);
        list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(new ArrayList<>());
        }
    }

    @Override
    public void writeMatrix() {
        for(int i=0;i<size;i++){
            System.out.print(i+": ");
            for(int j=0;j<size;j++){
                if(check(i,j)) System.out.print(j+" ");
                else System.out.print("0 ");
            }
            System.out.println();
        }
        
        
            
        
    }

    @Override
    public boolean check(int i, int j) throws IllegalArgumentException {
        try{
            return list.get(i).contains(j);
        }
        catch(Exception e){
            throw new IllegalArgumentException("Liczba spoza tablicy!");
        }
    }

    @Override
    public void connect(int i, int j) throws IllegalArgumentException {
        try{
            list.get(i).add(j);
        }
        catch(Exception e){
            throw new IllegalArgumentException("Liczba spoza tablicy!");
        }
    }

    @Override
    public void writeList() {
        int i= 0;
        for(List<Integer> lista: list){
            System.out.print(i+++": ");
            System.out.println(lista.toString());
                
            
        }
    }
    
    public void bezSasiadow(){
        for(int i=0;i<size;i++){
            if(list.get(i).isEmpty()) System.out.print(i+" ");
            
        }
        
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
        if (list.get(source).contains(destination)) {
            System.out.println("znalazłem połaczenie do " + destination);
            return true;
        }

        for(int i: list.get(source)) {
            if (!visited.contains(i)) kolekcja.add(i);


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

        if (list.get(source).contains(destination)) {
            System.out.println("znalazłem połaczenie do " + destination);
            return true;
        }

        for(int i: list.get(source)) {
            if (!visited.contains(i)) kolekcja.push(i);


        }
        visited.add(source);
        return hasPathDFS(destination, kolekcja, visited);

    }


}
