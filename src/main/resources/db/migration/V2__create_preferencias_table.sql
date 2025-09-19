-- Criação da tabela preferências de investimento (relacionamento N:M com clientes)
CREATE TABLE IF NOT EXISTS preferencias (
                                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                            cliente_id BIGINT NOT NULL,
                                            nome_preferencia VARCHAR(100) NOT NULL,

                                            CONSTRAINT fk_cliente
                                                FOREIGN KEY (cliente_id) REFERENCES clientes(id)
                                                    ON DELETE CASCADE
);
