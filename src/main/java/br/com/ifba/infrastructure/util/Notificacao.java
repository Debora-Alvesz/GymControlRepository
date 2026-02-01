/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 *
 * @author ketli
 */
@Slf4j
@Component
public class Notificacao {
    
    //simulando envio de notificação
    public void enviarEmail(String destinatario, String assunto, String corpo){
        log.info("[SIMULAÇÃO DE EMAIL] Para: {} | Assunto: {} | Msg: {}", 
                 destinatario, assunto, corpo);
    }
    
}
