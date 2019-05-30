package fatec.poo.model;

public class Pessoa {
    private String cpf;
    private String nome;
    private String endereco;
    private String cidade;
    private String uf;
    private String cep;
    private String ddd;
    private String telefone;
    
    public Pessoa(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getUf() {
        return uf;
    }

    public String getCep() {
        return cep;
    }

    public String getDdd() {
        return ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public static boolean validarCPF(String CPF) {
        int     d1, d2;
        int     digito1, digito2, resto;
        int     digitoCPF;
        String  nDigResult;

        CPF = CPF.replace(".","");
        CPF = CPF.replace("-","");
		
	if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222") 
			|| CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555") 
			|| CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888") || CPF.equals("99999999999") 
			|| (CPF.length() != 11)) {
            return (false);
        }
		
        d1 = d2 = 0;
        digito1 = digito2 = resto = 0;

        for (int nCount = 1; nCount < CPF.length() -1; nCount++)
        {
           digitoCPF = Integer.valueOf (CPF.substring(nCount -1, nCount)).intValue();

           //multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.
           d1 = d1 + ( 11 - nCount ) * digitoCPF;

           //para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.
           d2 = d2 + ( 12 - nCount ) * digitoCPF;
        };

        //Primeiro resto da divisão por 11.
        resto = (d1 % 11);

        //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.
        if (resto < 2)
           digito1 = 0;
        else
           digito1 = 11 - resto;

        d2 += 2 * digito1;

        //Segundo resto da divisão por 11.
        resto = (d2 % 11);

        //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.
        if (resto < 2)
           digito2 = 0;
        else
           digito2 = 11 - resto;

        //Digito verificador do CPF que está sendo validado.
        String nDigVerific = CPF.substring (CPF.length()-2, CPF.length());

        //Concatenando o primeiro resto com o segundo.
        nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

        //comparar o digito verificador do cpf com o primeiro resto + o segundo resto.
        return nDigVerific.equals(nDigResult);
    }
}