package br.com.estudos.edusocrates.pedidos.amqp;

import br.com.estudos.edusocrates.pedidos.dto.PagamentoDto;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PagamentoListener {

    @RabbitListener(queues = "pagamento.concluido")
    public void recebeMensagem(PagamentoDto pagamentoDto){
        String mensagem = """
                Dados do pagamento:  %s
                Numero do pedido:  %s
                Valor:  %s
                Status:  %s
                """.formatted(pagamentoDto.getId(),
                pagamentoDto.getPedidoId(),
                pagamentoDto.getValor(),
                pagamentoDto.getStatus());
        System.out.println("Recebi a mensagem: "+ mensagem);
    }


}
