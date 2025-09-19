-- Criação da tabela clientes
CREATE TABLE IF NOT EXISTS clientes (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        ativo BOOLEAN DEFAULT TRUE,

    -- Informações Pessoais
                                        nome VARCHAR(100) NOT NULL,
                                        cpf VARCHAR(14) NOT NULL UNIQUE,
                                        nacionalidade VARCHAR(50),
                                        data_nascimento DATE NOT NULL,
                                        telefone VARCHAR(20),
                                        email VARCHAR(100) NOT NULL,
                                        pais VARCHAR(50),

    -- Informações Financeiras
                                        renda_mensal DECIMAL(15,2) NOT NULL,
                                        patrimonio_liquido DECIMAL(15,2) NOT NULL,
                                        profissao VARCHAR(100),
                                        experiencia_investimentos VARCHAR(100),

    -- Perfil de Investidor
                                        perfil_investidor ENUM('CONSERVADOR','MODERADO','AGRESSIVO') NOT NULL,
                                        objetivo_investimento ENUM('CURTO_PRAZO','MEDIO_PRAZO','LONGO_PRAZO') NOT NULL,

    -- Informações Conta Bancária
                                        banco VARCHAR(50) NOT NULL,
                                        agencia VARCHAR(20) NOT NULL,
                                        numero_conta VARCHAR(20) NOT NULL,
                                        tipo_conta VARCHAR(20) NOT NULL,
                                        titular_conta VARCHAR(100) NOT NULL,

    -- Endereço (embeddable)
                                        logradouro VARCHAR(100) NOT NULL,
                                        numero VARCHAR(20) NOT NULL,
                                        complemento VARCHAR(50),
                                        bairro VARCHAR(50) NOT NULL,
                                        cidade VARCHAR(50) NOT NULL,
                                        estado CHAR(2) NOT NULL,
                                        cep CHAR(9) NOT NULL
);
