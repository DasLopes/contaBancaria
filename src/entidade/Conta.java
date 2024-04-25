package entidade;
//import entidade.Excecao;
public class Conta {

    private Integer numero;
    private String nome;
    private Double saldo;
    private Double limiteSaque;
    
    public Conta() {
    }

    public Conta(Integer numero, String nome, Double saldo, Double limiteSaque) {
        this.numero = numero;
        this.nome = nome;
        this.saldo = saldo;
        this.limiteSaque = limiteSaque;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Double getLimiteSaque() {
        return limiteSaque;
    }

    public void deposito(Double deposito){
        this.saldo += deposito;
    }

    public void saque(Double saque){
        validarSaque(saque);
    }

    private void validarSaque(Double saque){
        if (getLimiteSaque() > saque) {
            if (getSaldo() > saque) {
                this.saldo -= saque;                
            } else {                
                throw new Excecao("Saldo insuficiente");
            }            
        }else{
            throw new Excecao("Saque acima do permitido");
        }
    }
}
