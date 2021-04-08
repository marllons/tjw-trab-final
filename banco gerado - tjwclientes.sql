-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.7.32-log - MySQL Community Server (GPL)
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              11.2.0.6226
-- --------------------------------------------------------

-- Copiando estrutura do banco de dados para clientesjavaweb
CREATE DATABASE IF NOT EXISTS `clientesjavaweb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `clientesjavaweb`;

-- Copiando estrutura para tabela clientesjavaweb.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `idcliente` int(11) NOT NULL AUTO_INCREMENT,
  `dtnascimento` date DEFAULT NULL,
  `nome` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`idcliente`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Copiando estrutura para tabela clientesjavaweb.endereco
CREATE TABLE IF NOT EXISTS `endereco` (
  `idendereco` int(11) NOT NULL AUTO_INCREMENT,
  `CEP` varchar(8) DEFAULT NULL,
  `cidade` varchar(20) DEFAULT NULL,
  `enderecocol` varchar(45) DEFAULT NULL,
  `estado` varchar(15) DEFAULT NULL,
  `logradouro` varchar(80) DEFAULT NULL,
  `numero` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idendereco`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Copiando estrutura para tabela clientesjavaweb.telefone
CREATE TABLE IF NOT EXISTS `telefone` (
  `idtelefone` int(11) NOT NULL AUTO_INCREMENT,
  `telefone` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idtelefone`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Copiando estrutura para tabela clientesjavaweb.documentos
CREATE TABLE IF NOT EXISTS `documentos` (
  `cliente_idcliente` int(11) NOT NULL,
  `cpf` varchar(45) DEFAULT NULL,
  `rg` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cliente_idcliente`),
  CONSTRAINT `FKc36o2jkq23lregm7m96ajodj` FOREIGN KEY (`cliente_idcliente`) REFERENCES `cliente` (`idcliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando estrutura para tabela clientesjavaweb.telefone_dos_clientes
CREATE TABLE IF NOT EXISTS `telefone_dos_clientes` (
  `id_do_cliente` int(11) NOT NULL,
  `id_do_telefone` int(11) NOT NULL,
  KEY `FKstjhjefcrev1v16g1wag53he7` (`id_do_telefone`),
  KEY `FK9x4t0jvmtnxobiena3lc4gr39` (`id_do_cliente`),
  CONSTRAINT `FK9x4t0jvmtnxobiena3lc4gr39` FOREIGN KEY (`id_do_cliente`) REFERENCES `cliente` (`idcliente`),
  CONSTRAINT `FKstjhjefcrev1v16g1wag53he7` FOREIGN KEY (`id_do_telefone`) REFERENCES `telefone` (`idtelefone`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando estrutura para tabela clientesjavaweb.cliente_endereco
CREATE TABLE IF NOT EXISTS `cliente_endereco` (
  `cliente_idcliente` int(11) NOT NULL,
  `endereco_idendereco` int(11) NOT NULL,
  KEY `FKendk7667vom5bsco9nremjtip` (`endereco_idendereco`),
  KEY `FKjpydlk02pyisdyntmlj9uhk1g` (`cliente_idcliente`),
  CONSTRAINT `FKendk7667vom5bsco9nremjtip` FOREIGN KEY (`endereco_idendereco`) REFERENCES `endereco` (`idendereco`),
  CONSTRAINT `FKjpydlk02pyisdyntmlj9uhk1g` FOREIGN KEY (`cliente_idcliente`) REFERENCES `cliente` (`idcliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
