public enum TipoEscola {
    PU("Pública", 65),
    PR("Privada", 70),
    MT("Militar", 80);


// construtor do enum, para criar as caracteristicas
    TipoEscola(String descricao, int media){
        this.descricao = descricao;
        this.notaDeCorte = media;
    }

    private String descricao;
    private int notaDeCorte;

    public String getDescricao() {
        return descricao;
    }

    public int getNotaDeCorte() {
        return notaDeCorte;
    }
}
