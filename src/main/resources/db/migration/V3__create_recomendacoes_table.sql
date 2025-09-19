-- Criação da tabela de recomendações para histórico ou registro futuro
CREATE TABLE IF NOT EXISTS recomendacoes (
                                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                             cliente_id BIGINT NOT NULL,
                                             recomendacao TEXT NOT NULL,
                                             data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                                             CONSTRAINT fk_cliente_recomendacao
                                                 FOREIGN KEY (cliente_id) REFERENCES clientes(id)
                                                     ON DELETE CASCADE
);
