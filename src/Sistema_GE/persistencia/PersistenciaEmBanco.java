package Sistema_GE.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Sistema_GE.exception.ClienteJaCadastradoException;
import Sistema_GE.exception.FornecedorJaCadastradoException;
import Sistema_GE.exception.FuncionarioJaCadastradoException;
import Sistema_GE.exception.ProdutoJaCadastradoException;
import Sistema_GE.modelo.*;

public class PersistenciaEmBanco {

    private static PersistenciaEmBanco instance;

    private PersistenciaEmBanco() {
        // TODO Auto-generated constructor stub
    }

    public static PersistenciaEmBanco pegarInstancia()
    {
        if(instance != null)
            return instance;
        else
        {
            return instance = new PersistenciaEmBanco();
        }
    }

    public void cadastrarCliente(Cliente obj) throws ClienteJaCadastradoException{
        String sql = "insert into cliente "
                + " values (?,?,?,?,?,?);";

        try 
        {
            PreparedStatement pstmt = Conexao.getConnection().prepareStatement(sql);
            pstmt.setString(1, obj.getCpf());
            pstmt.setString(2, obj.getPrimeiroNome());
            pstmt.setString(3, obj.getUltimoNome());
            pstmt.setInt(4, obj.getIdade());
            pstmt.setString(5, obj.getEmail());
            pstmt.setString(6, obj.getSexo());
            
            pstmt.execute();
            pstmt.close();

        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
           throw new ClienteJaCadastradoException("Cliente já Cadastrado!");
        }
    }
    
    public void cadastrarProduto(Produto obj) throws ProdutoJaCadastradoException {
    	
    	if(obj instanceof Bolsa) {
    		
    		String sql = "insert into produto "
                    + " values (?,?,?,?,?,?);\n" 
    				+ "insert into bolsa (codigo_barras_produto, materia_prima, modelo) "
    				+ "values(?,?,?);";
       
        	try 
            {
                PreparedStatement pstmt = Conexao.getConnection().prepareStatement(sql);
                pstmt.setLong(1, obj.getCodigoDeBarra());
                pstmt.setString(2, obj.getNome());
                pstmt.setString(3, obj.getCor());
                pstmt.setFloat(4,  obj.getValor());
                pstmt.setString(5, obj.getMarca());
                pstmt.setInt(6, obj.getQuantidade());
                
                pstmt.setLong(7, obj.getCodigoDeBarra());
                pstmt.setString(8, ((Bolsa) obj).getMateriaPrima());
                pstmt.setString(9, ((Bolsa) obj).getModelo());
                
                pstmt.execute();
                pstmt.close();

            }
            catch (SQLException e) {
                // TODO Auto-generated catch block
               throw new ProdutoJaCadastradoException("Produto já Cadastrado!");
            }
    		
    	}else if (obj instanceof Calcado) {
    		String sql = "insert into produto"
                    + " values (?,?,?,?,?,?);\n" 
    				+ "insert into calcado (codigo_barras_produto, numero, modelo)"
    				+ "values(?,?,?);";
       
        	try 
            {
                PreparedStatement pstmt = Conexao.getConnection().prepareStatement(sql);
                pstmt.setLong(1, obj.getCodigoDeBarra());
                pstmt.setString(2, obj.getNome());
                pstmt.setString(3, obj.getCor());
                pstmt.setFloat(4,  obj.getValor());
                pstmt.setString(5, obj.getMarca());
                pstmt.setInt(6, obj.getQuantidade());
                
                pstmt.setLong(7, obj.getCodigoDeBarra());
                pstmt.setInt(8, ((Calcado) obj).getNumero());
                pstmt.setString(9, ((Calcado) obj).getModelo());
                
              
                pstmt.execute();
                pstmt.close();

            }
            catch (SQLException e) {
            	throw new ProdutoJaCadastradoException("Produto já Cadastrado!");
                // TODO Auto-generated catch block
            	
            }
    	}else if(obj instanceof Roupa) {
    		String sql = "insert into produto"
                    + " values (?,?,?,?,?,?);\n" 
    				+ "insert into roupa (codigo_barras_produto, tipo_tecido, tipo_roupa, tamanho)"
    				+ "values(?,?,?,?);";
       
        	try 
            {
                PreparedStatement pstmt = Conexao.getConnection().prepareStatement(sql);
                pstmt.setLong(1, obj.getCodigoDeBarra());
                pstmt.setString(2, obj.getNome());
                pstmt.setString(3, obj.getCor());
                pstmt.setFloat(4,  obj.getValor());
                pstmt.setString(5, obj.getMarca());
                pstmt.setInt(6, obj.getQuantidade());
                
                pstmt.setLong(7, obj.getCodigoDeBarra());
                pstmt.setString(8, ((Roupa) obj).getTipoTecido());
                pstmt.setString(9, ((Roupa) obj).getTipoRoupa());
                pstmt.setString(10, ((Roupa) obj).getTamanho());
                
              
                pstmt.execute();
                pstmt.close();

            }
            catch (SQLException e) {
                // TODO Auto-generated catch block
            	throw new ProdutoJaCadastradoException("Produto já Cadastrado!"); 	
            	}

    		}

    	}
    public void cadastrarForncedor(Fornecedor fornecedor) throws FornecedorJaCadastradoException{
        String sql = "insert into fornecedor"
                + " values (?,?,?,?,?);";

        try 
        {
            PreparedStatement pstmt = Conexao.getConnection().prepareStatement(sql);
            pstmt.setString(1, fornecedor.getCnpj());
            pstmt.setString(2, fornecedor.getRazaoSocial());
            pstmt.setString(3, fornecedor.getTelefone());
            pstmt.setString(4, fornecedor.getEmail());
            pstmt.setString(5, fornecedor.getPrincipalProduto());
            
            pstmt.execute();
            pstmt.close();

        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
           throw new FornecedorJaCadastradoException("Fornecedor já Cadastrado!");
        }
    }
    public void cadastrarFuncionario(Funcionario vendedor) throws FuncionarioJaCadastradoException{
        String sql = "insert into funcionario"
                + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

        try 
        {
            PreparedStatement pstmt = Conexao.getConnection().prepareStatement(sql);
            pstmt.setLong(1, vendedor.getMatricula());
            pstmt.setString(2, vendedor.getCpf());
            pstmt.setString(3, vendedor.getPrimeiroNome());
            pstmt.setString(4, vendedor.getUltimoNome());
            pstmt.setFloat(5, vendedor.getSalario());
            pstmt.setString(6, vendedor.getSexo());
            pstmt.setString(7, vendedor.getEstado());
            pstmt.setString(8, vendedor.getCidade());
            pstmt.setString(9, vendedor.getBairro());
            pstmt.setString(10, vendedor.getNumero());
            pstmt.setString(11, vendedor.getLogradouro());
            pstmt.setString(12, vendedor.getSenha());
            pstmt.setString(13, vendedor.getCargo());         
            pstmt.setInt(14, 0);
          
            pstmt.execute();
            pstmt.close();

        }
        catch (SQLException e) {
        	e.printStackTrace();
            // TODO Auto-generated catch block
           throw new FuncionarioJaCadastradoException("Funcionario já Cadastrado!");
        }
        
    }
    public String VerificaLogin(Long login, String senha){
    	
        String sql = "select matricula,senha,cargo from funcionario where matricula = ? and senha = ?; ";		

        try 
        {
            PreparedStatement pstmt = Conexao.getConnection().prepareStatement(sql);
       
            pstmt.setLong(1, login);
            pstmt.setString(2, senha);
            pstmt.execute();
            
            ResultSet rs = pstmt.getResultSet();

            if(rs.next()) {
            	String cargo = rs.getString(3);
            	if (cargo.equals("gerente")) {
            		return "Tela Gerente";
            		
            	}else {
            		return "Tela Vendedor";
            		
            	}
            }
            
            pstmt.close();
            
        }
        catch (SQLException e) {
        	
        	e.printStackTrace();
       
        }
        return "0";
 
    }
    public Funcionario funcionarioLogado(Long login, String senhaT) {
    	Funcionario funcionario = null;
        String sql = "select * from funcionario where matricula = ? and senha = ?; ";		

        try 
        {
            PreparedStatement pstmt = Conexao.getConnection().prepareStatement(sql);
       
            pstmt.setLong(1, login);
            pstmt.setString(2, senhaT);
            
            pstmt.execute();
             
            ResultSet rs = pstmt.getResultSet();

            if(rs.next()) {
	            Long matricula = rs.getLong(1);
	            String cpf = rs.getString(2);
	            String primeiroNome = rs.getString(3);
	            String ultimoNome = rs.getString(4);
	            float salario = rs.getFloat(5);
	            String sexo = rs.getString(6);
	            String estado = rs.getString(7);
	            String cidade = rs.getString(8);
	            String bairro = rs.getString(9);
	            String numero = rs.getString(10);
	            String logradouro = rs.getString(11);
	            String cargo = rs.getString(13);
	            
	            funcionario = new Funcionario(matricula, cpf, primeiroNome, ultimoNome, sexo, salario, logradouro, numero, cidade, bairro, estado, senhaT, cargo);         
            		
            	} 
            
            pstmt.close();
            

        }
        catch (SQLException e) {
        	e.printStackTrace();
            // TODO Auto-generated catch block
           ;
           
       
        }
        return funcionario;
 
    }
    public ArrayList <Fornecedor> todosFornecedores(){
    	
    	ArrayList<Fornecedor> listaTodosFornecedores = new ArrayList<Fornecedor>();
    	
        String sql = "select * from fornecedor;";		

        try 
        {
            PreparedStatement pstmt = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
            	String cnpj = rs.getString("cnpj");
            	String razaoSocial = rs.getString("razao_social");
            	String telefone = rs.getString("telefone");
            	String email = rs.getString("email");
            	String principalProduto = rs.getString("principal_produto");
            	
            	Fornecedor fornecedor = new Fornecedor(cnpj, razaoSocial, telefone, email, principalProduto);
            	listaTodosFornecedores.add(fornecedor);
            }
            
            pstmt.execute();
            pstmt.close();

        }
        
        catch (SQLException e) {
        	e.printStackTrace();
            // TODO Auto-generated catch block
  
        }
        return listaTodosFornecedores;
 
    }
    public ArrayList <Produto> todosProdutos(String nomel){
    	
    	ArrayList<Produto> listaTodosProdutos = new ArrayList<Produto>();
    	
        String sql = "select * from produto where nome like '%"+nomel+"%'";		

        try 
        {
            PreparedStatement pstmt = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
            	Long codigoBarras = rs.getLong("codigo_barras");
            	String nome = rs.getString("nome");
            	String cor = rs.getString("cor");
            	float valor = rs.getFloat("valor");
            	String marca = rs.getString("marca");
            	int quantidade = rs.getInt("quantidade");
            	
            	Produto produto = new Produto(codigoBarras, nome, marca, valor, cor, quantidade);
            	listaTodosProdutos.add(produto);
            }
            
            pstmt.execute();
            pstmt.close();

        }
        
        catch (SQLException e) {
        	e.printStackTrace();
            // TODO Auto-generated catch block
  
        }
        return listaTodosProdutos;
 
    }
    public ArrayList <Produto> todasBolsas(){
    	
    	ArrayList<Produto> listaTodasBolsas = new ArrayList<Produto>();
    	
        String sql = "select * from produto p, bolsa c "
        		+ "where p.codigo_barras = c.codigo_barras_produto ;";		

        try 
        {
            PreparedStatement pstmt = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
            	Long codigoBarras = rs.getLong("codigo_barras");
            	String nome = rs.getString("nome");
            	String cor = rs.getString("cor");
            	float valor = rs.getFloat("valor");
            	String marca = rs.getString("marca");
            	int quantidade = rs.getInt("quantidade");
            	
            	Produto bolsa = new Bolsa(codigoBarras, nome, marca, valor, cor, quantidade);
            	listaTodasBolsas.add(bolsa);
            }
            
            pstmt.execute();
            pstmt.close();

        }
        
        catch (SQLException e) {
        	e.printStackTrace();
            // TODO Auto-generated catch block
  
        }
        return listaTodasBolsas;
 
    }
    public ArrayList <Produto> todasRoupas(){
    	
    	ArrayList<Produto> listaTodasRoupas = new ArrayList<Produto>();
    	
        String sql = "select * from produto p, roupa c "
        		+ "where p.codigo_barras = c.codigo_barras_produto ;";		

        try 
        {
            PreparedStatement pstmt = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
            	Long codigoBarras = rs.getLong("codigo_barras");
            	String nome = rs.getString("nome");
            	String cor = rs.getString("cor");
            	float valor = rs.getFloat("valor");
            	String marca = rs.getString("marca");
            	int quantidade = rs.getInt("quantidade");
            	
            	Produto roupa = new Roupa(codigoBarras, nome, marca, valor, cor, quantidade);
            	listaTodasRoupas.add(roupa);
            }
            
            pstmt.execute();
            pstmt.close();

        }
        
        catch (SQLException e) {
        	e.printStackTrace();
            // TODO Auto-generated catch block
  
        }
        return listaTodasRoupas;
 
    }
    public ArrayList <Produto> todosCalcados(){
    	
    	ArrayList<Produto> listaTodasCalcados = new ArrayList<Produto>();
    	
        String sql = "select * from produto p, calcado c "
        		+ "where p.codigo_barras = c.codigo_barras_produto ;";		

        try 
        {
            PreparedStatement pstmt = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
            	Long codigoBarras = rs.getLong("codigo_barras");
            	String nome = rs.getString("nome");
            	String cor = rs.getString("cor");
            	float valor = rs.getFloat("valor");
            	String marca = rs.getString("marca");
            	int quantidade = rs.getInt("quantidade");
            	
            	Produto calcado = new Calcado(codigoBarras, nome, marca, valor, cor, quantidade);
            	listaTodasCalcados.add(calcado);
            }
            
            pstmt.execute();
            pstmt.close();

        }
        
        catch (SQLException e) {
        	e.printStackTrace();
            // TODO Auto-generated catch block
  
        }
        return listaTodasCalcados;
 
    }
    public ArrayList <Venda> todasVendas(){
    	
    	ArrayList<Venda> listaTodasVendas = new ArrayList<Venda>();
    	
        String sql = "select * from venda_prod";
        				

        try 
        {
            PreparedStatement pstmt = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
            	Long id = rs.getLong(1);
            	Long matriculaFuncionario = rs.getLong("matricula_funcionario");
            	Long codigoBarrasProduto = rs.getLong("codigo_barras_produto");
            	String cpfCliente = rs.getString("cpf_cliente");
            	String formaDePagamento = rs.getString("forma_de_pagamento");
            	
            	
            	Venda venda = new Venda(id, matriculaFuncionario, codigoBarrasProduto, cpfCliente, formaDePagamento);
            	listaTodasVendas.add(venda);
            }
            
            pstmt.execute();
            pstmt.close();

        }
        
        catch (SQLException e) {
        	e.printStackTrace();
            // TODO Auto-generated catch block
  
        }
        
        return listaTodasVendas;       
    
    }
    public ArrayList <Funcionario> todosFuncionarios(String nome){
    	
    	ArrayList<Funcionario> listaTodosFuncionarios = new ArrayList<Funcionario>();
    	
        String sql = "select * from funcionario where primeiro_nome like '%"+nome+"%'";	
        				

        try 
        {
            PreparedStatement pstmt = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
            	Long matricula = rs.getLong(1);
            	String cpf = rs.getString(2);
            	String primeiroNome = rs.getString(3);
            	String ultimoNome = rs.getString(4);
            	float salario = rs.getFloat(5);
            	String sexo = rs.getString(6);
            	String estado = rs.getString(7);
            	String cidade = rs.getString(8);
            	String bairro = rs.getString(9);
            	String numero = rs.getString(10);
            	String logradouro = rs.getString(11);
            	String cargo = rs.getString(13);
            	Long numeroDeVendas = rs.getLong(14);
            	
            	Funcionario funcionario = new Funcionario(matricula, cpf, primeiroNome, ultimoNome, sexo, salario, logradouro, numero, cidade, bairro, estado, numeroDeVendas, cargo);
            	listaTodosFuncionarios.add(funcionario);
            }
            
            pstmt.execute();
            pstmt.close();

        }
        
        catch (SQLException e) {
        	e.printStackTrace();
            // TODO Auto-generated catch block
  
        }
        
        return listaTodosFuncionarios;
	}
    public Fornecedor getFornecedor(String cnpj_selecionado){
    	String cnpj = "0";
        String razaoSocial= "0"; 
        String telefone= "0"; 
        String email= "0";
        String principalProduto= "0";
        Fornecedor fornecedor;
        
        String sql = "select * from fornecedor where cnpj = ?";

        try
        {
            PreparedStatement pstmt = Conexao.getConnection().prepareStatement(sql);
            pstmt.setString(1, cnpj_selecionado);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                cnpj = rs.getString("cnpj");
                razaoSocial = rs.getString("razao_social");
                telefone = rs.getString("telefone");
                email = rs.getString("email");
                principalProduto = rs.getString("principal_produto");

            }

            pstmt.execute();
            pstmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        fornecedor = new Fornecedor(cnpj, razaoSocial, telefone, email, principalProduto);
        return fornecedor;
    
    }
    public void UpdateFornecedor(String cnpj, Fornecedor fornecedor) {

        String sql = "update fornecedor set cnpj = ?, razao_social = ?, telefone = ?, email = ?, principal_produto = ? where cnpj = ?";
        		

        try 
        {
            PreparedStatement pstmt = Conexao.getConnection().prepareStatement(sql);
            pstmt.setString(1, fornecedor.getCnpj());
            pstmt.setString(2, fornecedor.getRazaoSocial());
            pstmt.setString(3, fornecedor.getTelefone());
            pstmt.setString(4, fornecedor.getEmail());
            pstmt.setString(5, fornecedor.getPrincipalProduto());
            pstmt.setString(6, cnpj);
    

            pstmt.execute();
            pstmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public int getQuantProduto(Long codigoDeBarras){

        String sql = "select quantidade from produto where codigo_barras=" + codigoDeBarras;

        try
        {
            PreparedStatement pstmt = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
            	int quantidade = rs.getInt(1);

                return quantidade;

            }

            pstmt.execute();
            pstmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
		return 0;
    }
    public void UpdateQuantProd(Long codigoDeBarras, int quantidade) {

        String sql = "update produto set quantidade = ? where codigo_barras = ?";
        		

        try 
        {
            PreparedStatement pstmt = Conexao.getConnection().prepareStatement(sql);
            pstmt.setInt(1, quantidade);
            pstmt.setLong(2, codigoDeBarras);

            pstmt.execute();
            pstmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public void deleteProduto(Long codigoDeBarras) {

        String sql = "delete from produto where codigo_barras = ?";
        		

        try 
        {
            PreparedStatement pstmt = Conexao.getConnection().prepareStatement(sql);
            pstmt.setLong(1, codigoDeBarras);

            pstmt.execute();
            pstmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void deleteFornecedor(String cnpj) {

        String sql = "delete from fornecedor where cnpj = ?";

        try 
        {
            PreparedStatement pstmt = Conexao.getConnection().prepareStatement(sql);
            pstmt.setString(1, cnpj);

            pstmt.execute();
            pstmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public ArrayList <Cliente> todosClientes(String nomeDoCliente){
    	
    	ArrayList<Cliente> listaTodasVendas = new ArrayList<Cliente>();
    	

    	String sql = "select * from cliente where primeiro_nome like '%"+nomeDoCliente+"%'";
        				
        try 
        {
            PreparedStatement pstmt = Conexao.getConnection().prepareStatement(sql);
            
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
            	
            	String cpf = rs.getString(1);
            	String primeiro_nome = rs.getString(2);
            	String ultimo_nome = rs.getString(3);
            	int idade = rs.getInt(4);
            	String email = rs.getString(5);
            	String sexo = rs.getString(6);

            	Cliente cliente = new Cliente(cpf, primeiro_nome, ultimo_nome, sexo, idade, sexo, email);
            	listaTodasVendas.add(cliente);
            }
            
            pstmt.execute();
            pstmt.close();

        }
        
        catch (SQLException e) {
        	e.printStackTrace();
            // TODO Auto-generated catch block
  
        }
        return listaTodasVendas;
    }
    
    public void novaVenda(Venda novaVenda) {

        String sql = "insert into venda_prod(matricula_funcionario, codigo_barras_produto, cpf_cliente, forma_de_pagamento) values (?,?,?,?);"+
        			 "update funcionario set numero_vendas = numero_vendas + 1 where matricula = ?;";

        		

        try 
        {
            PreparedStatement pstmt = Conexao.getConnection().prepareStatement(sql);
            pstmt.setLong(1, novaVenda.getMatriculaFuncionario());
            pstmt.setLong(2, novaVenda.getCodigoBarrasProduto());
            pstmt.setString(3, novaVenda.getCpfCliente());
            pstmt.setString(4, novaVenda.getFormaDePagamento());
            
            pstmt.setLong(5, novaVenda.getMatriculaFuncionario());

            pstmt.execute();
            pstmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
}
