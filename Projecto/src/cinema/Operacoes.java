/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema;

import java.awt.print.PrinterJob;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import myinputs.Ler;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

/**
 *
 * @author dlavareda
 */
public class Operacoes {

    //Metodo para converter string para localdate formato dd/mm/aaaa
    public static LocalDate dateInput(String userInput) {

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(userInput, dateFormat);
        return date;

    }

    //Metodo para converter string para localdate formato dd/mm/aaaa hh:mm
    public static LocalDateTime DateHInput(String userInput) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(userInput, formatter);
        return dateTime;
    }

    /*
    Metodo para enviar uma string para a impressora
    https://stackoverflow.com/questions/30544859/what-is-the-best-way-to-print-invoice-in-java
     */
    public static void printInvoice(String invoice) {
        try {
            PrintService mPrinter = null;
            Boolean bFoundPrinter = false;

            PrintService[] printServices = PrinterJob.lookupPrintServices();

            for (PrintService printService : printServices) {
                String sPrinterName = printService.getName();
                if (sPrinterName.equals("Black Cobra")) {
                    mPrinter = printService;
                    bFoundPrinter = true;
                }
            }
            String testData = invoice + "\f";
            InputStream is = new ByteArrayInputStream(testData.getBytes());
            DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;

            PrintService service = PrintServiceLookup.lookupDefaultPrintService();
            System.out.println(service);

            DocPrintJob job = service.createPrintJob();
            Doc doc = new SimpleDoc(is, flavor, null);

            job.print(doc, null);

            is.close();
        } catch (PrintException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //*----------------------------------------------Operações Salas----------------------------------------------*/
    //Metodo para listar uma Sala
    public static void mostrarSala(Salas sala) {
        Table t = new Table(6);
        t.addCell("Sala");
        t.addCell("Lugares Normais");
        t.addCell("Lugares Adaptados");
        t.addCell("Disponível?");
        t.addCell("Sala 3D");
        t.addCell("Custo por hora");
        t.addCell(String.valueOf(sala.getId()));
        t.addCell(String.valueOf(sala.getLugarN()));
        t.addCell(String.valueOf(sala.getLugarA()));
        t.addCell(String.valueOf(sala.getDisponivel()));
        t.addCell(String.valueOf(sala.getS3d()));
        t.addCell(String.valueOf(sala.getCustoHora()));
        System.out.println(t.render());
    }

    //Metodo para listar um ArrayList de Salas
    public static void listarSalas(ArrayList<Salas> salas) {
        Table t = new Table(6);
        t.addCell("Sala");
        t.addCell("Lugares Normais");
        t.addCell("Lugares Adaptados");
        t.addCell("Disponível?");
        t.addCell("Sala 3D");
        t.addCell("Custo por hora");

        for (int i = 0; i < salas.size(); i++) {
            t.addCell(String.valueOf(salas.get(i).getId()));
            t.addCell(String.valueOf(salas.get(i).getLugarN()));
            t.addCell(String.valueOf(salas.get(i).getLugarA()));
            t.addCell(String.valueOf(salas.get(i).getDisponivel()));
            t.addCell(String.valueOf(salas.get(i).getS3d()));
            t.addCell(String.valueOf(salas.get(i).getCustoHora()));
        }
        System.out.println(t.render());
    }

    //Metodo para criar uma nova sala pedindo os seus dados
    public static Salas novaSala(int lastid) {
        System.out.println("Numero de lugares normais:");
        int lugarN = Ler.umInt();
        System.out.println("Numero de lugares adaptados:");
        int lugarA = Ler.umInt();
        char c;
        boolean disponivel = false;
        do {
            System.out.println("Sala disponível? [s/n]");
            c = Ler.umChar();
            if (c == 's') {
                disponivel = true;
            } else if (c == 'n') {
                disponivel = false;
            } else {
                System.out.println("Resposta errada!");
            }
        } while (c != 's' && c != 'n');
        boolean s3d = false;
        do {
            System.out.println("Sala 3D? [s/n]");
            c = Ler.umChar();
            if (c == 's') {
                s3d = true;
            } else if (c == 'n') {
                s3d = false;
            } else {
                System.out.println("Resposta errada!");
            }
        } while (c != 's' && c != 'n');
        System.out.println("Custo por hora de filme:");
        double custohora = Ler.umDouble();
        Salas s = new Salas((lastid + 1), lugarN, lugarA, disponivel, s3d, custohora);
        return s;
    }

    //Metodo para inserir Sala no ArrayList
    public static void inserirSala(ArrayList<Salas> salas, Salas s) {

        salas.add(s);
        gravarFSalas(salas);

    }

    //Metodo para modificar Sala
    public static void modificarSala(ArrayList<Salas> salas, Salas s) {

        for (int i = 0; i < salas.size(); i++) {
            if (salas.get(i).equals(s)) {
                mostrarSala(s);
                int r;
                do {
                    System.out.println("1 – Modificar Numero de Lugares Normais");
                    System.out.println("2 – Modificar Numero de Lugares Adaptados");
                    System.out.println("3 – Modificar Disponibilidade");
                    System.out.println("4 – Modificar 3D");
                    System.out.println("5 – Modificar Custo Hora");
                    System.out.println("6 – Sair");
                    System.out.print("Opção: ");
                    r = Ler.umInt();
                    char c;
                    switch (r) {
                        case 1:
                            System.out.println("Introduza o novo numero de Lugares Normais:");
                            salas.get(i).setLugarN(Ler.umInt());
                            break;
                        case 2:
                            System.out.println("Introduza o novo numero de Lugares Adaptados:");
                            salas.get(i).setLugarA(Ler.umInt());
                            break;
                        case 3:
                            System.out.println("Sala disponível [s/n]");
                            c = Ler.umChar();
                            if (c == 's') {
                                salas.get(i).setDisponivel(true);
                            } else if (c == 'n') {
                                salas.get(i).setDisponivel(false);
                            } else {
                                System.out.println("Resposta errada s/n!");
                            }
                            break;
                        case 4:
                            System.out.println("Sala 3D [s/n]");
                            c = Ler.umChar();
                            if (c == 's') {
                                salas.get(i).setS3d(true);
                            } else if (c == 'n') {
                                salas.get(i).setS3d(false);
                            } else {
                                System.out.println("Resposta errada s/n!");
                            }
                            break;
                        case 5:
                            System.out.println("Introduza o novo custo por hora:");
                            salas.get(i).setCustoHora(Ler.umDouble());
                            break;
                    }

                } while (r != 6);
                gravarFSalas(salas);
            }
        }
    }

    //Metodo para apagar sala
    public static void apagarSala(ArrayList<Salas> salas, Salas s) {

        int r;
        for (int i = 0; i < salas.size(); i++) {
            if (salas.get(i).equals(s)) {
                mostrarSala(s);
                System.out.println("Deseja mesmo apagar a Sala [s/n}:");
                r = Ler.umChar();
                if (r == 's') {
                    salas.remove(i);
                    gravarFSalas(salas);
                    return;
                }
                return;
            }
        }
        //se chegar aqui é por que nao encontrou o elemento
        System.out.println("Sala não encontrada!!");
    }

    //Metodo para procurar uma sala mediante as escolhas do utilizador
    public static Salas procurarSala(ArrayList<Salas> salas) {
        Salas a = new Salas();
        int r;
        do {
            Table t = new Table(1);
            t.addCell("-------------Procurar Sala--------------");
            t.addCell("Pesquisar por:");
            t.addCell("1 – ID");
            t.addCell("2 – Sair");
            System.out.println(t.render());
            System.out.print("Opção: ");
            r = Ler.umInt();
            switch (r) {
                case 1:
                    System.out.println("Introduza o ID:");
                    int id = Ler.umInt();
                    for (int i = 0; i < salas.size(); i++) {
                        if (salas.get(i).getId() == id) {
                            return salas.get(i);
                        }
                    }
                    break;
            }

        } while (r != 2);
        return a;
    }

    //Metodo para ler do ficheiro salas.dat
    public static ArrayList<Salas> lerFSalas() {
        ArrayList<Salas> salas = new ArrayList<Salas>();
        //Le dados do ficheiro
        try {
            ObjectInputStream isSalas = new ObjectInputStream(new FileInputStream("salas.dat"));
            salas = (ArrayList) isSalas.readObject();
            isSalas.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return salas;
    }

    //Metodo para gravar ficheiro salas.dat
    public static void gravarFSalas(ArrayList<Salas> salas) {
        try {
            ObjectOutputStream osSalas = new ObjectOutputStream(new FileOutputStream("salas.dat"));
            // escrever o objeto lista no ficheiro
            osSalas.writeObject(salas);
            osSalas.flush();
            osSalas.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

//*----------------------------------------------Operações Bilhetes----------------------------------------------*/
    //Metodo para obter o numero de bilhetes normais comprados de uma sessao de um determinado filme
    public static int getBilhetesNormaisSessao(int filme, int sessao) {
        int count = 0;
        ArrayList<Filmes> filmes = new ArrayList<Filmes>();
        filmes = lerFFilmes();
        ArrayList<Sessoes> sessoes = new ArrayList<Sessoes>();
        for (int i = 0; i < filmes.size(); i++) {
            if (filmes.get(i).getId() == filme) {
                sessoes = filmes.get(i).getSessao();
            }
        }
        for (int i = 0; i < sessoes.size(); i++) {
            if (sessoes.get(i).getId() == sessao) {
                count = sessoes.get(i).getLugarN();
            }
        }
        return count;
    }

    //Metodo para obter o numero de bilhetes adaptados comprados de uma sessao de um determinado filme
    public static int contaBilhetesAdaptadosSessao(int filme, int sessao) {
        int count = 0;
        ArrayList<Filmes> filmes = new ArrayList<Filmes>();
        filmes = lerFFilmes();
        ArrayList<Sessoes> sessoes = new ArrayList<Sessoes>();
        for (int i = 0; i < filmes.size(); i++) {
            if (filmes.get(i).getId() == filme) {
                sessoes = filmes.get(i).getSessao();
            }
        }
        for (int i = 0; i < sessoes.size(); i++) {
            if (sessoes.get(i).getId() == sessao) {
                count = sessoes.get(i).getLugarA();
            }
        }
        return count;
    }

    //Método para obter os bilhetes de uma sessão
    public static ArrayList<Bilhetes> getBilhetesSessao() {
        ArrayList<Bilhetes> b = new ArrayList<Bilhetes>();

        ArrayList<Bilhetes> bilhetes = new ArrayList<Bilhetes>();

        bilhetes = lerFBilhetes();
        ArrayList<Filmes> filmes = new ArrayList<Filmes>();
        ArrayList<Sessoes> sessoes = new ArrayList<Sessoes>();
        filmes = Operacoes.lerFFilmes();
        Operacoes.listarFilmes(Operacoes.filmesEmExibicao(filmes));
        System.out.println("Qual o filme a consultar a sessão?");
        int s = Ler.umInt();
        int i;
        for (i = 0; i < filmes.size(); i++) {
            if (filmes.get(i).getId() == s) {
                sessoes = filmes.get(i).getSessao();
            }
        }
        Operacoes.listarSessoesFilmes(sessoes);
        System.out.println("Qual a sessao a listar bilhetes");
        int r = Ler.umInt();
        for (int j = 0; j < bilhetes.size(); j++) {
            if (bilhetes.get(j).getSessao() == r) {
                b.add(bilhetes.get(j));
            }
        }
        return (b);
    }

    //Método para listar os bilhetes da sessão mediante a pesquisa do utilizador
    public static void listarBilhetesSessao() {
        ArrayList<Bilhetes> b = new ArrayList<Bilhetes>();

        ArrayList<Bilhetes> bilhetes = new ArrayList<Bilhetes>();

        bilhetes = lerFBilhetes();
        ArrayList<Filmes> filmes = new ArrayList<Filmes>();
        ArrayList<Sessoes> sessoes = new ArrayList<Sessoes>();
        filmes = Operacoes.lerFFilmes();
        Operacoes.listarFilmes(Operacoes.filmesEmExibicao(filmes));
        System.out.println("Qual o filme a consultar a sessão?");
        int s = Ler.umInt();
        int i;
        for (i = 0; i < filmes.size(); i++) {
            if (filmes.get(i).getId() == s) {
                sessoes = filmes.get(i).getSessao();
            }
        }
        Operacoes.listarSessoesFilmes(sessoes);
        System.out.println("Qual a sessao a listar bilhetes");
        int r = Ler.umInt();
        for (int j = 0; j < bilhetes.size(); j++) {
            if (bilhetes.get(j).getSessao() == r) {
                b.add(bilhetes.get(j));
            }
        }
        listarBilhetes(b);
    }

    //Método para listar um bilhete em especifico
    public static void listarBilhetes(ArrayList<Bilhetes> b) {
        Table t = new Table(8);
        t.addCell("NIF Cliente");
        t.addCell("Nome Cliente");
        t.addCell("Sessao");
        t.addCell("Preço");
        t.addCell("Fila");
        t.addCell("Lugar");
        t.addCell("Filme");
        t.addCell("Metodo pagamento");
        for (int i = 0; i < b.size(); i++) {
            t.addCell(String.valueOf(b.get(i).getNif()));
            t.addCell(clientesGetByNIF(b.get(i).getNif()).getNome());
            t.addCell(String.valueOf(b.get(i).getSessao()));
            t.addCell(String.valueOf(b.get(i).getPreco()));
            t.addCell(String.valueOf(b.get(i).getFila()));
            t.addCell(String.valueOf(b.get(i).getLugar()));
            t.addCell(String.valueOf(Operacoes.getNomeById(b.get(i).getFilme())));
            if (b.get(i).getMetodopagar() == 1) {
                t.addCell("Numerário");
            } else if (b.get(i).getMetodopagar() == 2) {
                t.addCell("Multibanco");
            } else {
                t.addCell("MBWay");
            }

        }
        System.out.println(t.render());

    }

    //Método para vender um bilhete
    public static Bilhetes venderBilhete() {
        Bilhetes bilhete = new Bilhetes();
        ArrayList<Filmes> filmes = new ArrayList<Filmes>();
        ArrayList<Sessoes> sessoes = new ArrayList<Sessoes>();
        filmes = Operacoes.lerFFilmes();
        ArrayList<Salas> salas = new ArrayList<Salas>();
        salas = Operacoes.lerFSalas();
        Operacoes.listarFilmes(Operacoes.filmesEmExibicao(filmes));
        System.out.println("Qual o filme a vender bilhete?");
        int s = Ler.umInt();
        int i;
        for (i = 0; i < filmes.size(); i++) {
            if (filmes.get(i).getId() == s) {
                sessoes = filmes.get(i).getSessao();
            }
        }
        Operacoes.listarSessoesFilmes(sessoes);
        System.out.println("Qual a sessao a vender bilhete");
        int r = Ler.umInt();
        int j;
        for (j = 0; j < sessoes.size(); j++) {
            if (sessoes.get(j).getId() == r) {

                bilhete.setFilme(i);
                bilhete.setSessao(j);
                System.out.println("Qual o nif do cliente?");
                bilhete.setNif(Ler.umInt());
                if (clientesGetByNIF(bilhete.getNif()) == null) {
                    System.out.println("Por favor crie primeiro o cliente");
                    return null;
                }
                System.out.println("Qual a Fila?");
                bilhete.setFila(Ler.umChar());
                System.out.println("Qual o lugar?");
                bilhete.setLugar(Ler.umInt());
                System.out.println("Metodo de pagar (1-dinheiro/2-multibanco/3-MBWay)");
                bilhete.setMetodopagar(Ler.umInt());
                if (clientesGetByNIF(bilhete.getNif()) == null) {
                    System.out.println("NIF nao encontrado! Deve de registar primeiro o cliente");
                    return null;
                }
                //encontra a sala da sessao e retorna a capacidade
                int lugaresN = 0;
                int lugaresA = 0;
                for (int k = 0; k < salas.size(); k++) {
                    if (salas.get(k).getId() == sessoes.get(j).getSala()) {
                        lugaresN = salas.get(k).getLugarN();
                        lugaresA = salas.get(k).getLugarA();
                    }
                }

                //Verifica se existem ligares livres
                if (clientesGetByNIF(bilhete.getNif()).getLugaradpt() == true) {
                    if (contaBilhetesAdaptadosSessao(filmes.get(i).getId(), sessoes.get(j).getId()) == lugaresA) {
                        System.out.println("Sessão completa, sem lugares Adaptados disponiveis");
                        return null;
                    }
                } else {
                    if (getBilhetesNormaisSessao(filmes.get(i - 1).getId(), sessoes.get(j).getId()) == lugaresN) {
                        System.out.println("Sessão completa, sem lugares Normais disponiveis");
                        return null;
                    }
                }

                if (clientesGetByNIF(bilhete.getNif()).getEstudante() == true || clientesGetByNIF(bilhete.getNif()).getLugaradpt() == true) {
                    bilhete.setPreco(4.3);
                } else {
                    bilhete.setPreco(5.6);
                }
                double custo = 0;
                sessoes.get(j).setMontante(sessoes.get(j).getMontante() + bilhete.getPreco());
                for (int k = 0; k < salas.size(); k++) {
                    if (sessoes.get(j).getSala() == salas.get(k).getId()) {
                        custo = salas.get(k).getCustoHora() * (filmes.get(i - 1).getDuracao() / 60);
                    }
                }
                sessoes.get(j).setLucro(sessoes.get(j).getMontante() - custo);
                sessoes.get(j).setLugarN(sessoes.get(j).getLugarN() + 1);
            }
        }
        gravarFFilmes(filmes);
        return bilhete;
    }

    //Método para gerar e formatar o bilhete
    public static void gerarBilhete(Bilhetes bilhete) {
        int sala = 0;
        LocalDateTime dtSessao = null;

        ArrayList<Sessoes> sessoes = new ArrayList<Sessoes>();
        sessoes = getSessoesById(bilhete.getFilme());
        for (int i = 0; i < sessoes.size(); i++) {
            if (sessoes.get(i).getId() == bilhete.getSessao()) {
                dtSessao = sessoes.get(i).getDataHora();
                sala = sessoes.get(i).getSala();
            }
        }

        System.out.println("-------------------CINEUbi - Cinema Covilha---------------------");
        System.out.println("");
        System.out.println("");
        CellStyle numberStyle = new CellStyle(CellStyle.HorizontalAlign.right);
        Table t = new Table(2, BorderStyle.DESIGN_FORMAL, ShownBorders.SURROUND_HEADER_FOOTER_AND_COLUMNS);
        t.setColumnWidth(0, 56, 100);
        t.setColumnWidth(1, 7, 16);
        t.addCell("Filme");
        t.addCell("Valor", numberStyle);
        t.addCell(getNomeById(bilhete.getFilme()) + " - " + dtSessao.toString() + " - Sala " + sala + " - Fila " + bilhete.getFila() + " - Lugar " + bilhete.getLugar());
        t.addCell(String.valueOf(bilhete.getPreco() - (bilhete.getPreco() * 0.23)) + "€");
        t.addCell("IVA 23%");
        t.addCell(String.valueOf(bilhete.getPreco() * 0.23) + "€");
        t.addCell("Total", numberStyle);
        t.addCell(String.valueOf(bilhete.getPreco()) + "€", numberStyle);
        System.out.println(t.render());
        t.renderAsStringArray();
        System.out.println("");
        System.out.println("Iva Incluido á taxa em vigor 23%");
        System.out.println("");
        System.out.println("Obrigado por escolher o nosso cinema, desejamos-lhe um bom filme");
        char c;

        System.out.println("Deseja imprimir o bilhete [s/n]");
        c = Ler.umChar();
        if (c == 's') {
            printInvoice("-------------------CINEUbi - Cinema Covilha---------------------\n\n\n\n" + t.render() + "\n\n\nIva Incluido á taxa em vigor\n\n\nObrigado por escolher o nosso cinema, desejamos-lhe um bom filme");
        }

    }

    //Método para listar os bilhetes de uma sessão
    public static ArrayList<Bilhetes> listarBilhetesSessao(int sessao, int filme) {
        ArrayList<Bilhetes> bilhetes = new ArrayList<Bilhetes>();
        ArrayList<Bilhetes> b = new ArrayList<Bilhetes>();
        bilhetes = lerFBilhetes();
        for (int i = 0; i < bilhetes.size(); i++) {
            if (bilhetes.get(i).getFilme() == filme && bilhetes.get(i).getSessao() == sessao) {
                b.add(bilhetes.get(i));
            }
        }
        return b;
    }

    public static void apagarBilhete(Bilhetes bilhete) {
        ArrayList<Bilhetes> bilhetes = new ArrayList<Bilhetes>();
        bilhetes = lerFBilhetes();
        for (int i = 0; i < bilhetes.size(); i++) {
            if (bilhetes.get(i).equals(bilhete)) {
                bilhetes.remove(i);
            }
        }
        gravarFBilhetes(bilhetes);
    }

    //metodo ler do ficheiro bilhetes.dat
    public static ArrayList<Bilhetes> lerFBilhetes() {
        ArrayList<Bilhetes> bilhetes = new ArrayList<Bilhetes>();
        //Le dados do ficheiro
        try {
            ObjectInputStream isBilhetes = new ObjectInputStream(new FileInputStream("bilhetes.dat"));
            bilhetes = (ArrayList) isBilhetes.readObject();
            isBilhetes.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return bilhetes;
    }

    //metodo gravar ficheiro bilhetes.dat
    public static void gravarFBilhetes(ArrayList<Bilhetes> bilhetes) {
        try {
            ObjectOutputStream osBilhetes = new ObjectOutputStream(new FileOutputStream("bilhetes.dat"));
            // escrever o objeto lista no ficheiro
            osBilhetes.writeObject(bilhetes);
            osBilhetes.flush();
            osBilhetes.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

//*----------------------------------------------Operações Clientes----------------------------------------------*/
    public static Clientes novoCliente() {

        Pessoas p = new Pessoas();
        System.out.println("Introduza o nome");
        p.setNome(Ler.umaString());
        System.out.println("Introduza o NIF");
        p.setNif(Ler.umInt());
        System.out.println("Introduza a data de nascimento (dd/mm/aaaa)");
        LocalDate dtnasc = null;
        do {
            try {
                dtnasc = dateInput(Ler.umaString());
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data incorrecto, por favor utilize dd/mm/aaaa");
            }
        } while (dtnasc == null);
        p.setDtNascimento(dtnasc);
        Clientes cli = new Clientes(p);
        char c;
        do {
            System.out.println("Lugar Adaptado? [s/n]");
            c = Ler.umChar();
            if (c == 's') {
                cli.setLugaradpt(true);
            } else if (c == 'n') {
                cli.setLugaradpt(false);
            } else {
                System.out.println("Resposta errada! [s/n]");
            }
        } while (c != 's' && c != 'n');

        do {
            System.out.println("Estudante? [s/n]");
            c = Ler.umChar();
            if (c == 's') {
                cli.setEstudante(true);
            } else if (c == 'n') {
                cli.setEstudante(false);
            } else {
                System.out.println("Resposta errada! [s/n]");
            }
        } while (c != 's' && c != 'n');

        return cli;
    }
    //Listar clientes

    public static void mostrarCliente(Clientes cliente) {
        Table t = new Table(5);
        t.addCell("NIF");
        t.addCell("Nome");
        t.addCell("Data Nascimento");
        t.addCell("Estudante");
        t.addCell("Lugar Adaptado");
        t.addCell(String.valueOf(cliente.getNome()));
        t.addCell(String.valueOf(cliente.getNif()));
        t.addCell(String.valueOf(cliente.getDtNascimento().toString()));
        t.addCell(String.valueOf(cliente.getEstudante()));
        t.addCell(String.valueOf(cliente.getLugaradpt()));

        System.out.println(t.render());

    }

    public static void listarClientes(ArrayList<Clientes> clientes) {
        Table t = new Table(5);
        t.addCell("NIF");
        t.addCell("Nome");
        t.addCell("Data Nascimento");
        t.addCell("Estudante");
        t.addCell("Lugar Adaptado");
        for (int i = 0; i < clientes.size(); i++) {
            t.addCell(String.valueOf(clientes.get(i).getNome()));
            t.addCell(String.valueOf(clientes.get(i).getNif()));
            t.addCell(String.valueOf(clientes.get(i).getDtNascimento().toString()));
            t.addCell(String.valueOf(clientes.get(i).getEstudante()));
            t.addCell(String.valueOf(clientes.get(i).getLugaradpt()));

        }
        System.out.println(t.render());

    }

    //Inserir Clientes
    public static void inserirClientes(ArrayList<Clientes> clientes, Clientes c) {

        clientes.add(c);
        gravarFClientes(clientes);

    }

    //Modificar Sala
    public static void modificarClientes(ArrayList<Clientes> clientes, Clientes c) {

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).equals(c)) {
                mostrarCliente(c);
                int r;
                char s;
                do {
                    System.out.println("1 – Modificar Nome");
                    System.out.println("2 – Modificar Data de Nascimento");
                    System.out.println("3 – Modificar Lugar Adaptado");
                    System.out.println("4 – Modificar Estudante");
                    System.out.println("5 – Sair");
                    System.out.print("Opção: ");
                    r = Ler.umInt();
                    switch (r) {
                        case 1:
                            System.out.println("Introduza o novo Nome:");
                            clientes.get(i).setNome(Ler.umaString());
                            break;
                        case 2:
                            System.out.println("Introduza a nova data de nascimento (dd/mm/aaaa): ");
                            LocalDate dtnasc = null;
                            do {
                                try {
                                    dtnasc = dateInput(Ler.umaString());
                                } catch (DateTimeParseException e) {
                                    System.out.println("Formato de data incorrecto, por favor utilize dd/mm/aaaa");
                                }
                            } while (dtnasc == null);
                            clientes.get(i).setDtNascimento(dtnasc);
                            break;
                        case 3:
                            System.out.println("Lugar adaptado [s/n]");
                            s = Ler.umChar();
                            if (s == 's') {
                                clientes.get(i).setLugaradpt(true);
                            } else if (s == 'n') {
                                clientes.get(i).setLugaradpt(false);
                            } else {
                                System.out.println("Resposta errada s/n!");
                            }
                            break;
                        case 4:
                            System.out.println("Estudante [s/n]");
                            s = Ler.umChar();
                            if (s == 's') {
                                clientes.get(i).setEstudante(true);
                            } else if (s == 'n') {
                                clientes.get(i).setEstudante(false);
                            } else {
                                System.out.println("Resposta errada s/n!");
                            }
                            break;

                    }

                } while (r != 5);
                gravarFClientes(clientes);
            }
        }
    }

    public static void apagarClientes(ArrayList<Clientes> clientes, Clientes c) {

        int r;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).equals(c)) {
                mostrarCliente(c);
                System.out.println("Deseja mesmo apagar o CLiente [s/n}:");
                do {
                    r = Ler.umChar();
                    if (r == 's') {
                        clientes.remove(i);
                        gravarFClientes(clientes);
                        return;
                    } else if (r == 'n') {
                        return;
                    }
                } while (r != 's' && r != 'n');

            }
        }
        //se chegar aqui é por que nao encontrou o elemento
        System.out.println("Cliente não encontrado!!");
    }

    //Metodo para procurar um Cliente mediante as escolhas do utilizador
    public static Clientes procurarClientes(ArrayList<Clientes> clientes) {
        Clientes a = new Clientes();
        int r;
        do {
            Table t = new Table(1);
            t.addCell("-------------Procurar Clientes--------------");
            t.addCell("Pesquisar por:");
            t.addCell("1 – ID");
            t.addCell("2 – Nome");
            t.addCell("3 – Sair");
            System.out.println(t.render());
            System.out.print("Opção: ");
            r = Ler.umInt();
            switch (r) {
                case 1:
                    System.out.println("Introduza o NIF:");
                    double nif = Ler.umDouble();
                    for (int i = 0; i < clientes.size(); i++) {
                        if (clientes.get(i).getNif() == nif) {
                            //mostrarCliente(clientes.get(i));
                            return clientes.get(i);
                        }
                    }
                    //Se chegou aqui é porque nao encontrou nenhum cliente
                    System.out.println("Cliente não encontrado");
                    break;
                case 2:
                    System.out.println("Introduza o Nome:");
                    String s = Ler.umaString();
                    for (int i = 0; i < clientes.size(); i++) {
                        if (clientes.get(i).getNome().equalsIgnoreCase(s)) {
                            // mostrarCliente(clientes.get(i));
                            return clientes.get(i);
                        }
                    }
                    //Se chegou aqui é porque nao encontrou nenhum cliente
                    System.out.println("Cliente não encontrado");
                    break;
            }

        } while (r != 3);
        return a;
    }

    public static Clientes clientesGetByNIF(double NIF) {
        ArrayList<Clientes> clientes = new ArrayList<Clientes>();
        clientes = Operacoes.lerFClientes();
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getNif() == NIF) {
                return clientes.get(i);
            }

        }
        return null;
    }

    //metodo ler do ficheiro clientes.dat
    public static ArrayList<Clientes> lerFClientes() {
        ArrayList<Clientes> clientes = new ArrayList<Clientes>();
        //Le dados do ficheiro
        try {
            ObjectInputStream isClientes = new ObjectInputStream(new FileInputStream("clientes.dat"));
            clientes = (ArrayList) isClientes.readObject();
            isClientes.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return clientes;
    }

    //metodo gravar ficheiro clientes.dat
    public static void gravarFClientes(ArrayList<Clientes> clientes) {
        try {
            ObjectOutputStream osClientes = new ObjectOutputStream(new FileOutputStream("clientes.dat"));
            // escrever o objeto lista no ficheiro
            osClientes.writeObject(clientes);
            osClientes.flush();
            osClientes.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

//*----------------------------------------------Operações Filmes----------------------------------------------*/
    //metodo para listar filmes
    public static void mostrarFilme(Filmes filme) {

        Table t = new Table(9);
        t.addCell("ID");
        t.addCell("Nome");
        t.addCell("Genero");
        t.addCell("Rating");
        t.addCell("Duração");
        t.addCell("Realizadores");
        t.addCell("Atores");
        t.addCell("Data de entrada");
        t.addCell("Data de saida");

        t.addCell(String.valueOf(filme.getId()));
        t.addCell(String.valueOf(filme.getNome()));
        t.addCell(String.valueOf(filme.getGenero()));
        t.addCell(String.valueOf(filme.getRating()));
        t.addCell(String.valueOf(filme.getDuracao()));
        t.addCell(String.valueOf(filme.getRealizadores().toString()));
        t.addCell(String.valueOf(filme.getAtores().toString()));
        t.addCell(String.valueOf(filme.getDatain().toString()));
        t.addCell(String.valueOf(filme.getDataout().toString()));

        System.out.println(t.render());

    }

    public static void listarFilmes(ArrayList<Filmes> filmes) {
        Table t = new Table(9);
        t.addCell("ID");
        t.addCell("Nome");
        t.addCell("Genero");
        t.addCell("Rating");
        t.addCell("Duração");
        t.addCell("Realizadores");
        t.addCell("Atores");
        t.addCell("Data de entrada");
        t.addCell("Data de saida");

        for (int i = 0; i < filmes.size(); i++) {
            t.addCell(String.valueOf(filmes.get(i).getId()));
            t.addCell(String.valueOf(filmes.get(i).getNome()));
            t.addCell(String.valueOf(filmes.get(i).getGenero()));
            t.addCell(String.valueOf(filmes.get(i).getRating()));
            t.addCell(String.valueOf(filmes.get(i).getDuracao()));
            t.addCell(String.valueOf(filmes.get(i).getRealizadores().toString()));
            t.addCell(String.valueOf(filmes.get(i).getAtores().toString()));
            t.addCell(String.valueOf(filmes.get(i).getDatain().toString()));
            t.addCell(String.valueOf(filmes.get(i).getDataout().toString()));
        }
        System.out.println(t.render());
    }

    //metodo para criar um novo Filme pedindo os seus dados
    public static Filmes novoFilme(int lastid) {

        System.out.println("\nQual o nome?: ");
        Filmes f = new Filmes(Ler.umaString());
        f.setId(lastid + 1);
        //---------------------
        System.out.println("\nQual o Genero?: ");
        f.setGenero(Ler.umaString());
        //---------------------
        System.out.println("\nQual a idade minima?: ");
        f.setRating(Ler.umInt());
        //---------------------
        System.out.println("\nQual a duração?: ");
        f.setDuracao(Ler.umDouble());

        System.out.println("\nQual a Data de Entrada? (dia/mes/ano): ");
        LocalDate ldin = null;
        do {
            try {
                ldin = dateInput(Ler.umaString());
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data incorrecto, por favor utilize dd/mm/aaaa");
            }
        } while (ldin == null);
        f.setDatain(ldin);
        System.out.println("\nQual a Data de Saida?: (dia/mes/ano) ");
        LocalDate ldout = null;
        do {
            try {
                ldout = dateInput(Ler.umaString());
                f.setDataout(ldout);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data incorrecto, por favor utilize dd/mm/aaaa");
            }
        } while (ldout == null);
        //---------------------

        ArrayList<Atores> atores = new ArrayList<Atores>();
        System.out.println("\nQuantos atores vai ter?: ");
        int a = Ler.umInt();
        for (int i = 0; i < a; i++) {
            System.out.println("Qual o ator " + (i + 1) + "?:");
            Atores newator = new Atores(Ler.umaString());
            atores.add(newator);
        }
        f.setAtores(atores);

        ArrayList<Realizadores> realizadores = new ArrayList<Realizadores>();
        System.out.println("\nQuantos realizadores vai ter?: ");
        a = Ler.umInt();
        for (int i = 0; i < a; i++) {
            System.out.println("Qual o realizador " + (i + 1) + "?:");
            Realizadores newrealizador = new Realizadores(Ler.umaString());
            realizadores.add(newrealizador);
        }
        f.setRealizadores(realizadores);

        return f;
    }

    //metodo para inserir um novo Filme e gravar as alteraçoes feitas no ficheiro
    public static void inserirFilme(ArrayList<Filmes> filmes, Filmes f) {
        filmes.add(f);
        gravarFFilmes(filmes);
    }

    //metodo para alterar Filme e gravar as alteraçoes feitas no ficheiro
    public static void modificarFilme(ArrayList<Filmes> filmes, Filmes f) {

        for (int i = 0; i < filmes.size(); i++) {
            if (filmes.get(i).equals(f)) {
                mostrarFilme(f);
                int x;
                do {
                    System.out.println("1 – Modificar Nome");
                    System.out.println("2 – Modificar Genero");
                    System.out.println("3 – Modificar Rating");
                    System.out.println("4 – Modificar Duracao");
                    System.out.println("5 – Sair");
                    System.out.print("Opção: ");
                    x = Ler.umInt();
                    switch (x) {
                        case 1:
                            System.out.println("Introduza o novo nome:");
                            filmes.get(i).setNome(Ler.umaString());
                            break;
                        case 2:
                            System.out.println("Introduza o novo genero: ");
                            filmes.get(i).setGenero(Ler.umaString());
                            break;
                        case 3:
                            System.out.println("Introduza o novo rating: ");
                            filmes.get(i).setRating(Ler.umInt());
                            break;
                        case 4:
                            System.out.println("Introduza a nova duração: ");
                            filmes.get(i).setDuracao(Ler.umInt());
                            break;
                    }
                } while (x != 5);

                gravarFFilmes(filmes);
            }
        }
    }

    //metodo para apagar um Filme e gravar as alteraçoes feitas no ficheiro
    public static void apagarFilme(ArrayList<Filmes> filmes, Filmes f) {

        int x;
        for (int i = 0; i < filmes.size(); i++) {
            if (filmes.get(i).equals(f)) {
                mostrarFilme(f);
                System.out.println("Deseja mesmo apagar o Filme? [s/n]:");
                x = Ler.umChar();
                if (x == 's') {
                    filmes.remove(i);
                    gravarFFilmes(filmes);
                    return;
                }
                return;
            }
        }
        //se chegar aqui é por que nao encontrou o elemento
        System.out.println("Realizador não encontrado!!");
    }

    //Retorna todos os filmes de um dado realizador
    public static ArrayList<Filmes> filmesPorRealizador(ArrayList<Filmes> filmes, String realizador) {
        ArrayList<Filmes> f = new ArrayList<Filmes>();
        ArrayList<Realizadores> r = new ArrayList<Realizadores>();
        for (int i = 0; i < filmes.size(); i++) {
            r = filmes.get(i).getRealizadores();
            for (int j = 0; j < r.size(); j++) {
                if (realizador.compareToIgnoreCase(r.get(j).getNome()) == 0) {
                    f.add(filmes.get(i));
                }
            }
        }
        return f;
    }

    //Retorna todos os filmes de um dado ator
    public static ArrayList<Filmes> filmesPorAtor(ArrayList<Filmes> filmes, String ator) {
        ArrayList<Filmes> f = new ArrayList<Filmes>();
        ArrayList<Atores> a = new ArrayList<Atores>();
        for (int i = 0; i < filmes.size(); i++) {
            a = filmes.get(i).getAtores();
            for (int j = 0; j < a.size(); j++) {
                if (ator.compareToIgnoreCase(a.get(j).getNome()) == 0) {
                    f.add(filmes.get(i));
                }
            }
        }
        return f;
    }

    //Metodo para procurar um Filme mediante as escolhas do utilizador
    public static Filmes procurarFilme(ArrayList<Filmes> filmes) {
        Filmes f = new Filmes();
        int x;
        do {
            Table t = new Table(1);
            t.addCell("------------Procurar Filmes-------------");
            t.addCell("Pesquisar por:");
            t.addCell("1 – ID");
            t.addCell("2 – Nome");
            t.addCell("3 – Sair");
            System.out.println(t.render());
            System.out.print("Opção: ");
            x = Ler.umInt();
            switch (x) {
                case 1:
                    System.out.println("Introduza o ID:");
                    int id = Ler.umInt();
                    for (int i = 0; i < filmes.size(); i++) {
                        if (filmes.get(i).getId() == id) {
                            return filmes.get(i);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Introduza o Nome:");
                    String nome = Ler.umaString();
                    for (int i = 0; i < filmes.size(); i++) {
                        if (filmes.get(i).getNome().compareToIgnoreCase(nome) == 0) { //Compara os nomes, se forem iguais retorna 0
                            return filmes.get(i);
                        }
                    }
                    break;
            }
        } while (x != 3);
        return f;
    }

    public static String getNomeById(int id) {
        String s = new String();
        ArrayList<Filmes> filmes = new ArrayList<Filmes>();
        filmes = Operacoes.lerFFilmes();
        for (int i = 0; i < filmes.size(); i++) {
            if (filmes.get(i).getId() == id) {
                s = filmes.get(i).getNome();
            }
        }
        return s;
    }

    public static ArrayList<Sessoes> getSessoesById(int id) {
        ArrayList<Sessoes> sessoes = new ArrayList<Sessoes>();
        ArrayList<Filmes> filmes = new ArrayList<Filmes>();
        filmes = Operacoes.lerFFilmes();
        for (int i = 0; i < filmes.size(); i++) {
            if (filmes.get(i).getId() == id) {
                sessoes = filmes.get(i).getSessao();
            }
        }
        return sessoes;
    }

    public static ArrayList<Filmes> filmesEmExibicao(ArrayList<Filmes> filmes) {
        ArrayList<Filmes> f = new ArrayList<Filmes>();
        for (int i = 0; i < filmes.size(); i++) {
            if (filmes.get(i).getDataout().isAfter(LocalDate.now())) {
                f.add(filmes.get(i));
            }
        }

        return f;
    }

    public static ArrayList<Filmes> filmesAgendados(ArrayList<Filmes> filmes) {
        ArrayList<Filmes> f = new ArrayList<Filmes>();
        for (int i = 0; i < filmes.size(); i++) {
            if (filmes.get(i).getDatain().isAfter(LocalDate.now())) {
                f.add(filmes.get(i));
            }
        }

        return f;
    }

    public static ArrayList<Filmes> retirarFilmeExibicao(ArrayList<Filmes> filmes) {
        ArrayList<Filmes> f = new ArrayList<Filmes>();
        f = Operacoes.filmesEmExibicao(filmes);
        listarFilmes(f);
        System.out.println("Qual o ID filme a remover de exibição?");
        int r = Ler.umInt();
        for (int i = 0; i < filmes.size(); i++) {
            if (filmes.get(i).getId() == r) {
                filmes.get(i).setDataout(LocalDate.now());
            }
        }
        return filmes;
    }

    //metodo ler do ficheiro filmes.dat
    public static ArrayList<Filmes> lerFFilmes() {
        ArrayList<Filmes> filmes = new ArrayList<Filmes>();
        //Le dados do ficheiro
        try {
            ObjectInputStream isFilmes = new ObjectInputStream(new FileInputStream("filmes.dat"));
            filmes = (ArrayList) isFilmes.readObject();
            isFilmes.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return filmes;
    }

    //metodo gravar ficheiro atores.dat
    public static void gravarFFilmes(ArrayList<Filmes> filmes) {
        try {
            ObjectOutputStream osFilmes = new ObjectOutputStream(new FileOutputStream("filmes.dat"));
            // escrever o objeto lista no ficheiro
            osFilmes.writeObject(filmes);
            osFilmes.flush();
            osFilmes.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

//*----------------------------------------------Operações Sessões----------------------------------------------*/
    public static void listarSessao(Sessoes sessao) {
        Table t = new Table(7);
        t.addCell("ID");
        t.addCell("Sala");
        t.addCell("Data Hora");
        t.addCell("Numero de lugares normais ocupados");
        t.addCell("Numero de lugares adaptados ocupados");
        t.addCell("Lucro");
        t.addCell("Montante");

        t.addCell(String.valueOf(sessao.getId()));
        t.addCell(String.valueOf(sessao.getSala()));
        t.addCell(String.valueOf(sessao.getDataHora().toString()));
        t.addCell(String.valueOf(sessao.getLugarN()));
        t.addCell(String.valueOf(sessao.getLugarA()));
        t.addCell(String.valueOf(sessao.getLucro()));
        t.addCell(String.valueOf(sessao.getMontante()));

        System.out.println(t.render());
    }

//metodo para listar Sessoes
    public static void listarSessoesFilmes(ArrayList<Sessoes> sessoes) {

        Table t = new Table(7);
        t.addCell("ID");
        t.addCell("Sala");
        t.addCell("Data Hora");
        t.addCell("Numero de lugares normais");
        t.addCell("Numero de lugares adaptados");
        t.addCell("Lucro");
        t.addCell("Montante");

        for (int i = 0; i < sessoes.size(); i++) {
            t.addCell(String.valueOf(sessoes.get(i).getId()));
            t.addCell(String.valueOf(sessoes.get(i).getSala()));
            t.addCell(String.valueOf(sessoes.get(i).getDataHora().toString()));
            t.addCell(String.valueOf(sessoes.get(i).getLugarN()));
            t.addCell(String.valueOf(sessoes.get(i).getLugarA()));
            t.addCell(String.valueOf(sessoes.get(i).getLucro()));
            t.addCell(String.valueOf(sessoes.get(i).getMontante()));
        }
        System.out.println(t.render());
    }

    //metodo para criar uma nova Sessao pedindo os seus dados
    public static void novaSessao() {
        Sessoes s = new Sessoes();
        ArrayList<Filmes> filmes = new ArrayList<Filmes>();
        filmes = lerFFilmes();
        listarFilmes(filmesEmExibicao(filmes));
        System.out.println("Qual o ID do filme a criar sessão?");
        int r = Ler.umInt();
        s.setFilme(r);
        ArrayList<Sessoes> sessoes = new ArrayList<Sessoes>();
        int i;
        for (i = 0; i < filmes.size(); i++) {
            if (filmes.get(i).getId() == r) {
                sessoes = filmes.get(i).getSessao();
            }
        }
        int lastid = 0;
        if (sessoes.size() > 0) {
            lastid = sessoes.get(sessoes.size() - 1).getId() + 1;
        }
        s.setId(lastid);
        ArrayList<Salas> salas = new ArrayList<Salas>();
        salas = lerFSalas();
        listarSalas(salas);
        System.out.println("Qual a sala da sessão?");
        s.setSala(Ler.umInt());
        //---------------------
        System.out.println("Qual a Data?: (dd/mm/aaaa hh:mm)");
        LocalDateTime ldin = null;
        do {
            try {
                ldin = DateHInput(Ler.umaString());
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data incorrecto, por favor utilize dd/mm/aaaa hh:mm");
            }
        } while (ldin == null);
        s.setDataHora(ldin);
        sessoes.add(s);
        filmes.get(i - 1).setSessao(sessoes);
        gravarFFilmes(filmes);
    }

    //metodo para alterar uma Sesssao e gravar as alteraçoes feitas no ficheiro
    public static ArrayList<Sessoes> modificarSessao(ArrayList<Sessoes> sessoes, int id) {

        Salas sala = new Salas();
        for (int i = 0; i < sessoes.size(); i++) {
            if (sessoes.get(i).getId() == id) {
                listarSessao(sessoes.get(i));
                int x;
                do {
                    System.out.println("1 – Modificar Sala");
                    System.out.println("2 – Modificar Data e Hora");
                    System.out.println("3 – Sair");
                    System.out.print("Opção: ");
                    x = Ler.umInt();
                    switch (x) {
                        case 1:
                            System.out.println("Introduza a nova Sala:");
                            sessoes.get(i).setSala(Ler.umInt());
                            break;
                        case 2:
                            System.out.println("Qual a Data? (dd/mm/aaaa hh:mm): ");
                            LocalDateTime data = null;
                            do {
                                try {
                                    data = DateHInput(Ler.umaString());
                                } catch (DateTimeParseException e) {
                                    System.out.println("Formato de data incorrecto, por favor utilize dd/mm/aaaa hh:mm");
                                }
                            } while (data == null);
                            sessoes.get(i).setDataHora(data);
                            break;
                    }
                } while (x != 3);
            }
        }
        return sessoes;
    }

    //metodo para apagar uma Sessao e gravar as alteraçoes feitas no ficheiro
    public static ArrayList<Sessoes> apagarSessao(ArrayList<Sessoes> sessoes, int id) {

        int x;
        for (int i = 0; i < sessoes.size(); i++) {
            if (sessoes.get(i).getId() == id) {

                if (getBilhetesNormaisSessao(sessoes.get(i).getFilme(), id) == 0 && contaBilhetesAdaptadosSessao(sessoes.get(i).getFilme(), id) == 0) {

                    System.out.println("Deseja mesmo apagar a Sessao? [s/n]:");
                    x = Ler.umChar();
                    if (x == 's') {
                        sessoes.remove(i);
                        return sessoes;
                    }
                } else {
                    System.out.println("Erro!! A sessão tem bilhetes vendidos por favor apague os bilhetes primeiro.");
                    return sessoes;
                }
            }
        }
        //se chegar aqui é por que nao encontrou o elemento
        System.out.println("Sessao não encontrada!!");

        return sessoes;

    }

    //Metodo para procurar um Filme mediante as escolhas do utilizador
    public static Sessoes procurarSessao(ArrayList<Sessoes> sessoes) {
        Sessoes s = new Sessoes();
        int x;
        do {
            Table t = new Table(1);
            t.addCell("-------------Procurar Sessão--------------");
            t.addCell("Pesquisar por:");
            t.addCell("1 – ID");
            t.addCell("2 – Sala");
            t.addCell("3 – Data e Hora");
            t.addCell("4 – Filme");
            t.addCell("5 – Sair");
            System.out.println(t.render());
            System.out.print("Opção: ");
            x = Ler.umInt();
            switch (x) {
                case 1:
                    System.out.println("Introduza o ID:");
                    int id = Ler.umInt();
                    for (int i = 0; i < sessoes.size(); i++) {
                        if (sessoes.get(i).getId() == id) {
                            return sessoes.get(i);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Introduza a Sala:");
                    int sala = Ler.umInt();
                    for (int i = 0; i < sessoes.size(); i++) {
                        if (sessoes.get(i).getSala() == sala) {
                            return sessoes.get(i);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Qual a Data? (dia/mes/ano): ");
                    LocalDateTime data = null;
                    do {
                        try {
                            data = DateHInput(Ler.umaString());
                        } catch (DateTimeParseException e) {
                            System.out.println("Formato de data incorrecto, por favor utilize dd/mm/aaaa hh:mm");
                        }
                    } while (data == null);
                    for (int i = 0; i < sessoes.size(); i++) {
                        if (sessoes.get(i).getDataHora().isEqual(data) == true) { //Compara as datas 
                            return sessoes.get(i);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Introduza o Filme:");
                    int filme = Ler.umInt();
                    for (int i = 0; i < sessoes.size(); i++) {
                        if (sessoes.get(i).getFilme() == filme) {
                            return sessoes.get(i);
                        }
                    }
                    break;
            }
        } while (x != 6);
        return s;
    }

    public static ArrayList<Sessoes> ListaProxSessoes(ArrayList<Filmes> filmes) { // lista das sessoes seguintes ate ao final do dia desde a data atual
        ArrayList<Sessoes> sessoes = new ArrayList<Sessoes>();
        ArrayList<Sessoes> ses = new ArrayList<Sessoes>();
        for (int k = 0; k < filmes.size(); k++) {
            ses = filmes.get(k).getSessao();
            for (int l = 0; l < ses.size(); l++) {
                if (ses.get(l).getDataHora().isAfter(LocalDateTime.now())) {
                    sessoes.add(ses.get(l));
                }
            }
        }
        return sessoes;
    }

    //metodo ler do ficheiro sessoes.dat
    public static ArrayList<Sessoes> lerFSessoes() {
        ArrayList<Sessoes> sessoes = new ArrayList<Sessoes>();
        //Le dados do ficheiro
        try {
            ObjectInputStream isSessoes = new ObjectInputStream(new FileInputStream("sessoes.dat"));
            sessoes = (ArrayList) isSessoes.readObject();
            isSessoes.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return sessoes;
    }

    //metodo gravar ficheiro sessoes.dat
    public static void gravarFSessoes(ArrayList<Sessoes> sessoes) {
        try {
            ObjectOutputStream osFilmes = new ObjectOutputStream(new FileOutputStream("sessoes.dat"));
            // escrever o objeto lista no ficheiro
            osFilmes.writeObject(sessoes);
            osFilmes.flush();
            osFilmes.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

//*----------------------------------------------Operações Realizadores----------------------------------------------*/
//metodo para listar realizadores
    public static void listarRealizadores(ArrayList<Realizadores> realizadores) {
        Table t = new Table(2);
        t.addCell("ID");
        t.addCell("Nome:");
        for (int i = 0; i < realizadores.size(); i++) {
            t.addCell(String.valueOf(realizadores.get(i).getId()));
            t.addCell(String.valueOf(realizadores.get(i).getNome()));
        }
        System.out.println(t.render());
    }

//Realizadores diferentes
    public static ArrayList<Realizadores> listaRealizadores(ArrayList<Filmes> filmes) {
        ArrayList<Realizadores> realizadores = new ArrayList<Realizadores>();
        for (int i = 0; i < filmes.size(); i++) {
            ArrayList<Realizadores> r = new ArrayList<Realizadores>();
            r = filmes.get(i).getRealizadores();
            for (int j = 0; j < r.size(); j++) {
                if (realizadores.isEmpty()) {
                    realizadores.add(r.get(j));
                }
                for (int k = 0; k < realizadores.size(); k++) {
                    if (realizadores.get(k).getNome().equals(r.get(j).getNome())) {
                        break;
                    }
                    if (k == (realizadores.size() - 1)) {
                        //chegou ao fim e nao encontrou nenhum
                        realizadores.add(r.get(j));
                    }
                }
            }
        }
        return realizadores;
    }

    //metodo ler do ficheiro realizadores.dat
    public static ArrayList<Realizadores> lerFRealizadores() {
        ArrayList<Realizadores> realizadores = new ArrayList<Realizadores>();
        //Le dados do ficheiro
        try {
            ObjectInputStream isRealizadores = new ObjectInputStream(new FileInputStream("realizadores.dat"));
            realizadores = (ArrayList) isRealizadores.readObject();
            isRealizadores.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return realizadores;
    }

    //metodo gravar ficheiro realizadores.dat
    public static void gravarFRealizadores(ArrayList<Realizadores> realizadores) {
        try {
            ObjectOutputStream osFilmes = new ObjectOutputStream(new FileOutputStream("realizadores.dat"));
            // escrever o objeto lista no ficheiro
            osFilmes.writeObject(realizadores);
            osFilmes.flush();
            osFilmes.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //*----------------------------------------------Operações Atores----------------------------------------------*/
    //metodo para listar Atores
    public static void listarAtores(ArrayList<Atores> atores) {
        Table t = new Table(2);
        t.addCell("ID");
        t.addCell("Nome:");
        for (int i = 0; i < atores.size(); i++) {
            t.addCell(String.valueOf(atores.get(i).getId()));
            t.addCell(String.valueOf(atores.get(i).getNome()));
        }
        System.out.println(t.render());
    }

//Atores diferentes
    public static ArrayList<Atores> listaAtores(ArrayList<Filmes> filmes) {
        ArrayList<Atores> atores = new ArrayList<Atores>();
        for (int i = 0; i < filmes.size(); i++) {
            ArrayList<Atores> a = new ArrayList<Atores>();
            a = filmes.get(i).getAtores();
            for (int j = 0; j < a.size(); j++) {
                if (atores.isEmpty()) {
                    atores.add(a.get(j));
                }
                for (int k = 0; k < atores.size(); k++) {
                    if (atores.get(k).getNome().equals(a.get(j).getNome())) {
                        break;
                    }
                    if (k == (atores.size() - 1)) {
                        //chegou ao fim e nao encontrou nenhum
                        atores.add(a.get(j));
                    }
                }
            }
        }
        return atores;
    }

    //metodo ler do ficheiro atores.dat
    public static ArrayList<Atores> lerFAtores() {
        ArrayList<Atores> atores = new ArrayList<Atores>();
        //Le dados do ficheiro
        try {
            ObjectInputStream isAtores = new ObjectInputStream(new FileInputStream("atores.dat"));
            atores = (ArrayList) isAtores.readObject();
            isAtores.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return atores;
    }

    //metodo gravar ficheiro atores.dat
    public static void gravarFAtores(ArrayList<Atores> atores) {
        try {
            ObjectOutputStream osAtores = new ObjectOutputStream(new FileOutputStream("atores.dat"));
            // escrever o objeto lista no ficheiro
            osAtores.writeObject(atores);
            osAtores.flush();
            osAtores.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
