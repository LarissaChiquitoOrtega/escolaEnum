import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        String nomeAluno;
        String tipoEscola;
        int[] notasAtividades;
        int notaProva;
        int notaParticipacao;

        nomeAluno = lerNomeAluno(ler);
        tipoEscola = lerTipoEscola(ler);
        notasAtividades  = lerNotasAtividades(ler);
        notaProva = lerNotaProva(ler);
        notaParticipacao = lerNotaParticipacao(ler);

        //criando enum, não precisa de new, pq não é classe
        TipoEscola tipo = TipoEscola.valueOf(tipoEscola);

        int somaNotas = notaProva + notaParticipacao;
        for (int notas : notasAtividades){
            somaNotas += notas;
        }

        boolean aprovado = verificarAprovacao(tipo, somaNotas);

        if (aprovado) {
            System.out.printf("O Aluno %s foi APROVADO. Total de pontos %d", nomeAluno, somaNotas);
        }else{
            System.out.printf("O Aluno %s foi REPROVADO. Total de pontos %d", nomeAluno, somaNotas);
        }
    }

    public static boolean verificarAprovacao(TipoEscola tipo, int somaNotas) {

        if(somaNotas >= tipo.getNotaDeCorte()){
            return true;
        } else {
            return false;
        }
    }

    private static int  lerNotaParticipacao(Scanner ler) {
        int notaParticipacao;
        System.out.println("Nota Participação: ");
        do {
            notaParticipacao = ler.nextInt();
            if (notaParticipacao > 20){
                System.out.println("A nota de participação não pode ser maior que 20: Informe novamente: ");
            }
        }while (notaParticipacao > 20);
        return notaParticipacao;
    }

    private static int lerNotaProva(Scanner ler) {
        int notaProva;
        System.out.println("Nota Prova: ");
        do {
            notaProva = ler.nextInt();
            if (notaProva > 50){
                System.out.println("A nota da prova não pode ser maior que 50: Informe novamente: ");
            }
        }while (notaProva > 50);
        return notaProva;
    }

    private static int[] lerNotasAtividades(Scanner ler) {
        int[] notasAtividades = new int[3];
        for (int i = 0; i < notasAtividades.length; i++) {
            System.out.println("Nota atividade " + (i  + 1) +":");
            int nota;
            do {
                nota = ler.nextInt();
                if (nota > 10){
                    System.out.println("A nota da atividade "+(i+1)+" não pode ser maior que 10. Informe novamente: ");
                }
            }while (nota > 10);
            notasAtividades[i] = nota;
        }
        return notasAtividades;
    }

    public static String lerNomeAluno(Scanner ler){
        System.out.println("Nome do aluno: ");
        String nomeAluno = ler.next();
        return  nomeAluno;
    }

    public static String lerTipoEscola(Scanner ler){

        for (TipoEscola value : TipoEscola.values()) {
            System.out.print(value + " - " + value.getDescricao() + ", ");
        }
        System.out.println();

        System.out.println("Escolha um tipo de escola: ");
        String tipoEscola =  ler.next();
        switch (tipoEscola){
            case "PU" :
            case "PR" :
            case "MT" :
                break;
            default:
                System.out.println("A escola do tipo "+tipoEscola+" não existe.");
                System.exit(0);
        }
        return  tipoEscola;
    }
}