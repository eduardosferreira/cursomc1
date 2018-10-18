package com.nelioalves.cursomc;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.domain.Cidade;
import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.domain.Endereco;
import com.nelioalves.cursomc.domain.Estado;
import com.nelioalves.cursomc.domain.Produto;
import com.nelioalves.cursomc.domain.enums.TipoCliente;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.repositories.CidadeRepository;
import com.nelioalves.cursomc.repositories.ClienteRepository;
import com.nelioalves.cursomc.repositories.EnderecoRepository;
import com.nelioalves.cursomc.repositories.EstadoRepository;
import com.nelioalves.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria("Informática");
		Categoria cat2 = new Categoria("Escritório");
		
		Produto p1 = new Produto("Computador",2000.00d);
		Produto p2 = new Produto("Impressora",800.00d);
		Produto p3 = new Produto("Mouse",80.00d);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.setCategorias(p1.getCategorias());
	
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado("Minas Gerais");
		Estado est2 = new Estado("São Paulo");
		
		Cidade c1 = new Cidade("Uberlândia",est1);
		Cidade c2 = new Cidade("São Paulo",est2);
		Cidade c4 = new Cidade("Belo Horizonte",est1);
		Cidade c3 = new Cidade("Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(c1,c4));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3,c4));

		Cliente cli1 = new Cliente("Maria Silva"
									,"maria@gmail.com"
									,"00000000000"
									,TipoCliente.toEnum(1));
		
		Cliente cliPollyana = new Cliente("Pollyana Oliveira Martins Ferreira"
				,"pollyana.oliveira@gmail.com"
				,"98782134120"
				,TipoCliente.toEnum(1));

		
		Cliente cliMeiPollyana = new Cliente("MEI Pollyana Oliveira Martins Ferreira 98782134120"
				,"pollyana.oliveira@gmail.com"
				,"30.024.564/0001-25"
				,TipoCliente.toEnum(2));
		
		Endereco e1 = new Endereco("Rua Flores",
								   "300",
								   "Apt 203",
								   "Jardim",
								   "38220634",
								   c1,
								   cli1);

		Endereco e2 = new Endereco("Avenida Mattos",
				   "105",
				   "Sala 800",
				   "Centro",
				   "38777012",
				   c2,
				   cli1);

		Endereco ePollyana = new Endereco("Rua Marco Aurelio Pereira",
				   "71",
				   "FUNDO",
				   "Jardim Brasilia",
				   "38401668",
				   c1,
				   cliPollyana);

		Endereco eMeiPollyana = new Endereco("Rua Marco Aurelio Pereira",
				   "71",
				   "LOJA",
				   "Jardim Brasilia",
				   "38401668",
				   c1,
				   cliMeiPollyana);
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		Set<String> telefones = new HashSet<>();
		telefones.add("553432335001");
		telefones.add("551132555001");
		cli1.setTelefones(telefones);
		
		cliPollyana.getEnderecos().addAll(Arrays.asList(ePollyana));
		cliPollyana.setTelefones(telefones);

		cliMeiPollyana.getEnderecos().addAll(Arrays.asList(eMeiPollyana));
		cliMeiPollyana.setTelefones(telefones);
				
		clienteRepository.saveAll(Arrays.asList(cli1,cliPollyana,cliMeiPollyana));
		enderecoRepository.saveAll(Arrays.asList(e1,e2,eMeiPollyana,ePollyana));
		
	
	}
}
