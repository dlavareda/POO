/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema;

import java.io.IOException;
import java.util.ArrayList;
import myinputs.Ler;
import org.nocrala.tools.texttablefmt.Table;

/**
 *
 * @author dlavareda
 */
public class Main {

    public static void submenuGestaoAtores() {

        ArrayList<Filmes> filmes = new ArrayList<Filmes>();
        filmes = Operacoes.lerFFilmes();
        ArrayList<Atores> atores = new ArrayList<Atores>();
        atores = Operacoes.lerFAtores();
        int r;
        do {
            Table t = new Table(1);
            t.addCell("-------------Gestão Atores--------------");
            t.addCell("1 – Listar Atores");
            t.addCell("2 – Sair");
            System.out.println(t.render());
            System.out.print("Opção: ");
            r = Ler.umInt();
            switch (r) {
                case 1:
                    Operacoes.listarAtores(atores);
                    break;
            }

        } while (r != 2);
    }

    public static void submenuGestaoRealizadores() {

        ArrayList<Filmes> filmes = new ArrayList<Filmes>();
        filmes = Operacoes.lerFFilmes();
        ArrayList<Realizadores> realizadores = new ArrayList<Realizadores>();
        realizadores = Operacoes.lerFRealizadores();
        int r;
        do {
            Table t = new Table(1);
            t.addCell("----------Gestão Realizadores-----------");
            t.addCell("1 – Listar Realizadores");
            t.addCell("2 – Sair");
            System.out.println(t.render());
            System.out.print("Opção: ");
            r = Ler.umInt();
            switch (r) {
                case 1:
                    Operacoes.listarRealizadores(realizadores);
                    break;
            }

        } while (r != 2);
    }

    //sub-menu nivel 1 Bilhetes
    public static void submenuBilhetes() {
        int r;
        do {
            Table t = new Table(1);
            t.addCell("----------------Bilhetes----------------");
            t.addCell("1 – Vender bilhete");
            t.addCell("2 – Listar bilhetes de uma sessão");
            t.addCell("3 – Apagar bilhete");
            t.addCell("4 – Sair");
            System.out.println(t.render());
            System.out.print("Opção: ");
            r = Ler.umInt();
            switch (r) {
                case 1:
                    ArrayList<Bilhetes> bilhetes = new ArrayList<Bilhetes>();
                    Bilhetes bilhete = new Bilhetes();
                    bilhetes = Operacoes.lerFBilhetes();
                    bilhete = Operacoes.venderBilhete();
                    if (bilhete != null) { //para o caso de o vender bilhete ser interrompido
                        bilhetes.add(bilhete);
                        Operacoes.gerarBilhete(bilhete);
                        Operacoes.gravarFBilhetes(bilhetes);
                    }
                    break;
                case 2:
                    Operacoes.listarBilhetesSessao();
                    break;
                case 3:
                    ArrayList<Bilhetes> b = new ArrayList<Bilhetes>();
                    b = Operacoes.getBilhetesSessao();
                    Operacoes.listarBilhetes(b);
                    System.out.println("Qual o NIF do cliente a apagar a sessao?");
                    int s = Ler.umInt();
                    for (int i = 0; i < b.size(); i++) {
                        if (b.get(i).getNif() == s) {
                            System.out.println("Tem a certeza que deseja apagar o bilhete [s/n]");
                            char c = Ler.umChar();
                            if (c == 's') {
                                Operacoes.apagarBilhete(b.get(i));
                                //falta actualizar o numero numero de bilhetes vendidos na sessao
                            }

                        }
                    }
                    break;
            }

        } while (r != 4);
    }

    //Sub-menu nivel 1 Gestão do cinema
    public static void submenuGestao() {
        int r;
        do {
            Table t = new Table(1);
            t.addCell("-----------------Gestão-----------------");
            t.addCell("1 – Gerir Salas");
            t.addCell("2 – Gerir Filmes");
            t.addCell("3 – Gerir Sessoes");
            t.addCell("4 – Gerir Clientes");
            t.addCell("5 – Gerir Atores");
            t.addCell("6 – Gerir Realizadores");
            t.addCell("7 – Sair");
            System.out.println(t.render());
            System.out.print("Opção: ");
            r = Ler.umInt();
            switch (r) {
                case 1:
                    submenuGestaoSalas();
                    break;
                case 2:
                    submenuGestaoFilmes();

                    break;
                case 3:
                    submenuGestaoSessoes();

                    break;
                case 4:
                    submenuGestaoClientes();

                    break;
                case 5:
                    submenuGestaoAtores();

                    break;
                case 6:
                    submenuGestaoRealizadores();

                    break;
            }

        } while (r != 7);
    }
    //Sub-menu nivel 2 Gestão do cinema -> Gerir Salas

    public static void submenuGestaoSalas() {

        ArrayList<Salas> salas = new ArrayList<Salas>();
        salas = Operacoes.lerFSalas();
        int r;
        do {
            Table t = new Table(1);
            t.addCell("--------------Gestão Salas--------------");
            t.addCell("1 – Listar Salas");
            t.addCell("2 – Inserir Sala");
            t.addCell("3 – Modificar Salas");
            t.addCell("4 – Apagar Salas");
            t.addCell("5 – Sair");
            System.out.println(t.render());
            System.out.print("Opção: ");
            r = Ler.umInt();
            switch (r) {
                case 1:
                    Operacoes.listarSalas(salas);
                    break;
                case 2:
                    int size = 0;
                    for (int i = 0; i < salas.size(); i++) {
                        size++;
                    }
                    Operacoes.inserirSala(salas, Operacoes.novaSala(size));
                    break;
                case 3:
                    Operacoes.modificarSala(salas, Operacoes.procurarSala(salas));
                    break;
                case 4:
                    Operacoes.apagarSala(salas, Operacoes.procurarSala(salas));
                    break;
            }

        } while (r != 5);

    }
    //Sub-menu nivel 2 Gestão do cinema -> Gerir Filmes

    public static void submenuGestaoFilmes() {

        ArrayList<Filmes> filmes = new ArrayList<Filmes>();
        filmes = Operacoes.lerFFilmes();
        ArrayList<Realizadores> realizadores = new ArrayList<Realizadores>();
        realizadores = Operacoes.lerFRealizadores();
        ArrayList<Atores> atores = new ArrayList<Atores>();
        atores = Operacoes.lerFAtores();
        int r;
        do {
            Table t = new Table(1);
            t.addCell("-------------Gestão Filmes--------------");
            t.addCell("1 – Listar Filmes");
            t.addCell("2 – Inserir Filme");
            t.addCell("3 – Modificar Filmes");
            t.addCell("4 – Apagar Filmes");
            t.addCell("5 – Consultar Filmes em Exibição");
            t.addCell("6 – Consultar Filmes em Breve");
            t.addCell("7 – Listar por ator");
            t.addCell("8 – Listar por realizador");
            t.addCell("9 – Retirar filme de exibição");
            t.addCell("10 – Sair");
            System.out.println(t.render());
            System.out.print("Opção: ");
            r = Ler.umInt();
            switch (r) {
                case 1:
                    Operacoes.listarFilmes(filmes);
                    break;
                case 2:
                    int lastid = 0;
                    if (filmes.size() > 0) {
                        lastid = filmes.get(filmes.size() - 1).getId();
                    }
                    Operacoes.inserirFilme(filmes, Operacoes.novoFilme(lastid));
                    Operacoes.gravarFRealizadores(Operacoes.listaRealizadores(filmes));
                    Operacoes.gravarFAtores(Operacoes.listaAtores(filmes));
                    break;
                case 3:
                    Operacoes.modificarFilme(filmes, Operacoes.procurarFilme(filmes));
                    Operacoes.gravarFRealizadores(Operacoes.listaRealizadores(filmes));
                    Operacoes.gravarFAtores(Operacoes.listaAtores(filmes));
                    break;
                case 4:

                    Operacoes.apagarFilme(filmes, Operacoes.procurarFilme(filmes));
                    Operacoes.gravarFRealizadores(Operacoes.listaRealizadores(filmes));
                    Operacoes.gravarFAtores(Operacoes.listaAtores(filmes));
                    break;
                case 5:
                    Operacoes.listarFilmes(Operacoes.filmesEmExibicao(filmes));
                    break;
                case 6:
                    Operacoes.listarFilmes(Operacoes.filmesAgendados(filmes));

                    break;
                case 7:
                    Operacoes.listarAtores(Operacoes.listaAtores(filmes));
                    System.out.println("Qual o nome do ator a consultar os filmes?");
                    String a = Ler.umaString();
                    Operacoes.listarFilmes(Operacoes.filmesPorAtor(filmes, a));
                    break;

                case 8:
                    Operacoes.listarRealizadores(Operacoes.listaRealizadores(filmes));
                    System.out.println("Qual o nome do realizador a consultar os filmes?");
                    String realizador = Ler.umaString();
                    Operacoes.listarFilmes(Operacoes.filmesPorRealizador(filmes, realizador));
                    break;
                case 9:
                    filmes = Operacoes.retirarFilmeExibicao(filmes);
                    Operacoes.gravarFFilmes(filmes);
                    break;

            }

        } while (r != 10);
    }

    //Sub-menu nivel 2 Gestão do cinema -> Gerir Sessoes
    public static void submenuGestaoSessoes() {
        int r;
        ArrayList<Filmes> filmes = new ArrayList<Filmes>();
        filmes = Operacoes.lerFFilmes();
        do {
            Table t = new Table(1);
            t.addCell("-------------Gestão Sessoes-------------");
            t.addCell("1 – Listar Sessoes");
            t.addCell("2 – Inserir Sessão");
            t.addCell("3 – Modificar Sessão");
            t.addCell("4 – Apagar Sessoes");
            t.addCell("5 – Sair");
            System.out.println(t.render());
            System.out.print("Opção: ");
            r = Ler.umInt();
            ArrayList<Sessoes> sessoes = new ArrayList<Sessoes>();
            switch (r) {
                case 1:
                    filmes = Operacoes.lerFFilmes();
                    Operacoes.listarFilmes(Operacoes.filmesEmExibicao(filmes));
                    System.out.println("Qual o filme a consultar as sessoes?");
                    int f = Ler.umInt();
                    for (int i = 0; i < filmes.size(); i++) {
                        if (filmes.get(i).getId() == f) {
                            Operacoes.listarSessoesFilmes(filmes.get(i).getSessao());
                        }
                    }

                    break;
                case 2:
                    Operacoes.novaSessao();

                    break;
                case 3:
                    filmes = Operacoes.lerFFilmes();
                    Operacoes.listarFilmes(Operacoes.filmesEmExibicao(filmes));
                    System.out.println("Qual o filme a modificar a sessão?");
                    int s = Ler.umInt();
                    int i;
                    for (i = 0; i < filmes.size(); i++) {
                        if (filmes.get(i).getId() == s) {
                            sessoes = filmes.get(i).getSessao();
                        }
                    }
                    Operacoes.listarSessoesFilmes(sessoes);
                    System.out.println("Qual o ID da sessao a modificar?");
                    int id = Ler.umInt();
                    sessoes = Operacoes.modificarSessao(sessoes, id);
                    filmes.get(i - 1).setSessao(sessoes);
                    Operacoes.gravarFFilmes(filmes);
                    break;
                case 4:
                    filmes = Operacoes.lerFFilmes();
                    Operacoes.listarFilmes(Operacoes.filmesEmExibicao(filmes));
                    System.out.println("Qual o filme a apagar sessão?");
                    int s1 = Ler.umInt();
                    int j;
                    for (j = 0; j < filmes.size(); j++) {
                        if (filmes.get(j).getId() == s1) {
                            sessoes = filmes.get(j).getSessao();
                        }
                    }
                    Operacoes.listarSessoesFilmes(sessoes);
                    System.out.println("Qual o ID da sessao a apagar?");
                    int id1 = Ler.umInt();
                    sessoes = Operacoes.apagarSessao(sessoes, id1);
                    filmes.get(j - 1).setSessao(sessoes);
                    Operacoes.gravarFFilmes(filmes);
                    break;
            }

        } while (r != 5);
    }
    //Sub-menu nivel 2 Gestão do cinema -> Gerir Clientes

    public static void submenuGestaoClientes() {

        ArrayList<Clientes> clientes = new ArrayList<Clientes>();
        clientes = Operacoes.lerFClientes();
        int r;
        do {
            Table t = new Table(1);
            t.addCell("------------Gestão Clientes-------------");
            t.addCell("1 – Listar Clientes");
            t.addCell("2 – Consultar Cliente");
            t.addCell("3 – Inserir Cliente");
            t.addCell("4 – Modificar Cliente");
            t.addCell("5 – Apagar Cliente");
            t.addCell("6 – Sair");
            System.out.println(t.render());
            System.out.print("Opção: ");
            r = Ler.umInt();
            switch (r) {
                case 1:
                    Operacoes.listarClientes(clientes);
                    break;
                case 2:
                    Operacoes.mostrarCliente(Operacoes.procurarClientes(clientes));
                    break;
                case 3:
                    Operacoes.inserirClientes(clientes, Operacoes.novoCliente());
                    break;
                case 4:
                    Operacoes.modificarClientes(clientes, Operacoes.procurarClientes(clientes));
                    break;
                case 5:
                    Operacoes.apagarClientes(clientes, Operacoes.procurarClientes(clientes));
                    break;
            }

        } while (r != 6);

    }

    //Sub-menu nivel 1 Estatisticas
    public static void submenuEstatisticas() {
        int r;
        do {
            Table t = new Table(1);
            t.addCell("---------------Estatiticas--------------");
            t.addCell("1 – Estatisticas Salas");
            t.addCell("2 – Estatisticas Filmes");
            t.addCell("3 – Estatisticas Sessoes");
            t.addCell("4 – Estatisticas Clientes");
            t.addCell("5 – Estatisticas Atores");
            t.addCell("6 – Estatisticas Realizadores");
            t.addCell("7 – Estatisticas Cinema");
            t.addCell("8 – Sair");
            System.out.println(t.render());
            System.out.print("Opção: ");

            r = Ler.umInt();
            switch (r) {
                case 1:
                    submenuEstatisticasSalas();
                    break;
                case 2:
                    submenuEstatisticasFilmes();

                    break;
                case 3:
                    submenuEstatisticasSessoes();

                    break;
                case 4:
                    submenuEstatisticasClientes();

                    break;
                case 5:
                    submenuEstatisticasAtores();

                    break;
                case 6:
                    submenuEstatisticasRealizadores();

                    break;
                case 7:
                    submenuEstatisticasCinema();

                    break;

            }

        } while (r != 8);
    }
//Sub-menu nivel 2 Estatisticas->Salas

    public static void submenuEstatisticasSalas() {
        ArrayList<Salas> salas = new ArrayList<Salas>();
        salas = Operacoes.lerFSalas();
        ArrayList<Filmes> filmes = new ArrayList<Filmes>();
        filmes = Operacoes.lerFFilmes();
        int r, z;
        double lotacao;
        do {
            Table t = new Table(1);
            t.addCell("------------Estatiticas Salas-----------");
            t.addCell("1 – Total de lotação da Sala a nível semanal ");
            t.addCell("2 – Sair");
            System.out.println(t.render());
            System.out.print("Opção: ");
            r = Ler.umInt();
            switch (r) {
                case 1:
                    System.out.println("Salas para verificar: ");
                    Operacoes.listarSalas(salas);
                    z = Ler.umInt();
                    lotacao = Estatisticas.mediaLotacaoSala(salas.get(z-1), filmes);
                    System.out.println(" Lotação da sala " + z + ": " + lotacao);
                    break;
                case 2:
                    break;
            }

        } while (r != 2);
    }

    //Sub-menu nivel 2 Estatisticas->Filmes
    public static void submenuEstatisticasFilmes() {
        ArrayList<Filmes> filmes = new ArrayList<Filmes>();
        filmes = Operacoes.lerFFilmes();
        int r, z;
        double lucro;
        do {
            Table t = new Table(1);
            t.addCell("-----------Estatiticas Filmes-----------");
            t.addCell("1 – Lucro do Filme");
            t.addCell("2 – Sair");
            System.out.println(t.render());
            System.out.print("Opção: ");
            r = Ler.umInt();

            switch (r) {
                case 1:
                    System.out.println("Filme: ");
                    Operacoes.listarFilmes(filmes);
                    System.out.println("Qual o id do filme a consultar o lucro?");
                    z = Ler.umInt();
                    lucro = Estatisticas.lucroVendasFilme(filmes.get(z - 1));
                    System.out.println("Lucro: " + lucro);
                    break;
            }

        } while (r != 2);
    }

    //Sub-menu nivel 2 Estatisticas->Sessoes
    public static void submenuEstatisticasSessoes() {
        ArrayList<Filmes> filmes = new ArrayList<Filmes>();
        filmes = Operacoes.lerFFilmes();
        int r, z;
        double totalvendas;
        do {
            Table t = new Table(1);
            t.addCell("----------Estatiticas Sessoes-----------");
            t.addCell("1 – Total do valor de vendas de filme por sessao");
            t.addCell("2 – Sair");
            System.out.println(t.render());
            System.out.print("Opção: ");
            r = Ler.umInt();
            switch (r) {
                case 1:
                    Operacoes.listarFilmes(filmes);
                    System.out.println("Qual o filme a consultar?");
                    z = Ler.umInt();
                    ArrayList<Sessoes> s = new ArrayList<Sessoes>();
                    s = Operacoes.getSessoesById(z);
                    Operacoes.listarSessoesFilmes(s);
                    int y = Ler.umInt();
                    totalvendas = s.get(y).getMontante();
                    System.out.println("Valor total de vendas: " + totalvendas);
                    break;
            }

        } while (r != 2);
    }

    //Sub-menu nivel 2 Estatisticas->Clientes
    public static void submenuEstatisticasClientes() {
        int r;
        do {
            ArrayList<Clientes> clientes = new ArrayList<Clientes>();
            clientes = Operacoes.lerFClientes();
            Table t = new Table(1);
            t.addCell("----------Estatiticas Clientes----------");
            t.addCell("1 – Numero de idas ao cinema do cliente");
            t.addCell("2 – Sair");
            System.out.println(t.render());
            System.out.print("Opção: ");
            r = Ler.umInt();
            int z;
            switch (r) {
                case 1:

                    System.out.println("Clientes: ");
                    Operacoes.listarClientes(clientes);
                    System.out.println("Qual o NIF do cliente a consultar?");
                    z = Ler.umInt();
                    System.out.println("Foi " + Estatisticas.numVezesClienteCinema(Operacoes.clientesGetByNIF(z)) + " vezes");
                    break;

            }

        } while (r != 2);
    }

    //Sub-menu nivel 2 Estatisticas->Atores
    public static void submenuEstatisticasAtores() {
        ArrayList<Atores> atores = new ArrayList<Atores>();
        atores = Operacoes.lerFAtores();

        int r;
        String s;

        ArrayList<Filmes> filmes = new ArrayList<Filmes>();
        filmes = Operacoes.lerFFilmes();
        do {
            Table t = new Table(1);
            t.addCell("-----------Estatiticas Atores-----------");
            t.addCell("1 – Numero de Filmes por ator");
            t.addCell("2 – Sair");
            System.out.println(t.render());
            System.out.print("Opção: ");
            r = Ler.umInt();
            switch (r) {
                case 1:
                    System.out.println("Atores: ");/*
                    for(int i=0;i<atores.size();i++){
                        System.out.println(i + " - " + "id: " + atores.get(i).toString());
                    }*/
                    Operacoes.listarAtores(atores);
                    System.out.println("Escreva um nome do ator: ");
                    s = Ler.umaString();

                    System.out.println("O ator " + s + " fez " + Estatisticas.totalFilmesAtor(filmes, s) + " filme(s)");

                    break;

            }

        } while (r != 2);
    }

    //Sub-menu nivel 2 Estatisticas->Realizadores
    public static void submenuEstatisticasRealizadores() {
        ArrayList<Realizadores> realizadores = new ArrayList<Realizadores>();
        realizadores = Operacoes.lerFRealizadores();
        String s;

        int r;

        ArrayList<Filmes> filmes = new ArrayList<Filmes>();
        filmes = Operacoes.lerFFilmes();
        do {
            Table t = new Table(1);
            t.addCell("--------Estatiticas Realizadores--------");
            t.addCell("1 – Numero de filmes do realizador");
            t.addCell("2 – Sair");
            System.out.println(t.render());
            System.out.print("Opção: ");
            r = Ler.umInt();
            switch (r) {
                case 1:
                    System.out.println("Realizadores: ");
                    Operacoes.listarRealizadores(realizadores);
                    System.out.println("Escreva um nome de realizador: ");
                    s = Ler.umaString();
                    System.out.println("Número de filmes do realizador " + s + " é: " + Estatisticas.totalFilmesRealizador(filmes, s));

            }

        } while (r != 2);
    }
    //Sub-menu nivel 2 Estatisticas->Cinema

    public static void submenuEstatisticasCinema() {
        ArrayList<Filmes> filmes = new ArrayList<Filmes>();
        filmes = Operacoes.lerFFilmes();
        int r;
        do {
            Table t = new Table(1);
            t.addCell("----------Estatiticas Sessoes-----------");
            t.addCell("1 – Total do valor de vendas de filme por sessao");
            t.addCell("2 – Sair");
            System.out.println(t.render());
            System.out.print("Opção: ");
            r = Ler.umInt();
            switch (r) {
                case 1:
                    System.out.println(Estatisticas.lucrototal(filmes));
                    break;
            }

        } while (r != 2);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        int r;

        
        do {
            Table t = new Table(1);
            t.addCell("-------------Menu Principal-------------");
            t.addCell("1 – Bilhetes");
            t.addCell("2 – Gestão do cinema");
            t.addCell("3 – Estatisticas");
            t.addCell("4 – Sair");
            System.out.println(t.render());
            System.out.print("Opção: ");
            r = Ler.umInt();
            switch (r) {
                case 1:

                    submenuBilhetes();
                    break;
                case 2:
                    submenuGestao();
                    break;
                case 3:
                    submenuEstatisticas();
                    break;
            }

        } while (r != 4);

    }

}
