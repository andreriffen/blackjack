/* 
import java.awt.* ; //(Abstract Window Toolkit) cria interfaces gráficas, fornece classes para janelas, botões, eventos de mouse, etc
import java.awt.event.* ; 

import javax.swing.*; // GUI semelhante AWT, por exemplo: JOptionPane para caixas de diálogo */
import java.util.Random; 
import java.util.ArrayList; //armazena coleções de objetos 


//no java tem que importar tudo, até as coisas mais básicas

public class BlackJack {
    
    //atributos
    private class Carta{
        String valor;
        String naipe;

    //construtor 
    Carta(String valor, String naipe){
        this.valor = valor;
        this.naipe = naipe;
    }

        //exibir nome das cartas
        public String toString(){
            return valor + "-" + naipe;
        }

    }

    ArrayList<Carta> baralho;
    Random sorteio = new Random();

    BlackJack(){
        iniciarJogo();
    }

    public void iniciarJogo(){
        //baralho
        montarBaralho();
        embaralhar();
    }



    public void montarBaralho(){
        baralho = new ArrayList<Carta>();
        String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] naipes = {"C", "D", "H", "S"}; //Clubs= Paus, Diamond= Ouro, Hearts= Copas, Spades=Espada

        for(int i = 0; i < naipes.length; i++){ 
            for(int j = 0; j < valores.length; j++){ 
                Carta carta = new Carta(valores[j],naipes[i]); // naipe = j, valor = i
                baralho.add(carta);
            }
        }

        System.out.println("MONTAR BARALHO");
        System.out.println(baralho);
    }

    public void embaralhar(){
        for(int i = 0; i < baralho.size(); i++){
            int j = sorteio.nextInt(baralho.size()); //sorteia carta de 0 a 51
            Carta cartaAtual = baralho.get(i);
            Carta cartaAleatoria = baralho.get(j);
            baralho.set(i, cartaAleatoria);
            baralho.set(j, cartaAtual);
        }

        System.out.println("DEPOIS DE EMBARALHAR");
        System.out.println(baralho);
    }
}
