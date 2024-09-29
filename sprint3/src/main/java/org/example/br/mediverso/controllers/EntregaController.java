package org.example.br.mediverso.controllers;

import org.example.br.mediverso.models.Entrega;
import org.example.br.mediverso.services.EntregaServices.CreateEntregaService;
import org.example.br.mediverso.services.EntregaServices.GetEntregaById;
import org.example.br.mediverso.services.EntregaServices.GetEntregas;

import java.util.List;

public class EntregaController {

    private final CreateEntregaService createEntregaService;
    private final GetEntregaById getEntregaByIdService;
    private final GetEntregas getEntregasService;

    public EntregaController() {
        this.createEntregaService = new CreateEntregaService();
        this.getEntregaByIdService = new GetEntregaById();
        this.getEntregasService = new GetEntregas();
    }

    // Método para criar uma nova entrega recebendo os dados diretamente
    public void createEntrega(int tarefaId, int placarId) {
        Entrega entrega = new Entrega();
        entrega.setTarefaId(tarefaId);
        entrega.setPlacarId(placarId);

        createEntregaService.createEntrega(entrega);
        System.out.println("Entrega criada com sucesso!");
    }

    // Método para buscar uma entrega por ID recebendo o ID diretamente
    public Entrega getEntregaById(int id) {
        Entrega entrega = getEntregaByIdService.getEntregaById(id);
        if (entrega != null) {
            System.out.println("Entrega encontrada:");
            System.out.println("ID: " + entrega.getId());
            System.out.println("Tarefa ID: " + entrega.getTarefaId());
            System.out.println("Placar ID: " + entrega.getPlacarId());
            return entrega;
        } else {
            System.out.println("Entrega não encontrada.");
            return null;
        }
    }

    // Método para listar todas as entregas sem interação
    public List<Entrega> listAllEntregas() {
        System.out.println("=== Listar todas as Entregas ===");
        List<Entrega> entregas = getEntregasService.getAllEntregas();

        if (entregas.isEmpty()) {
            System.out.println("Nenhuma entrega encontrada.");
        } else {
            for (Entrega entrega : entregas) {
                System.out.println("ID: " + entrega.getId());
                System.out.println("Tarefa ID: " + entrega.getTarefaId());
                System.out.println("Placar ID: " + entrega.getPlacarId());
                System.out.println("-----------------------------");
            }
        }
        return entregas;
    }

    // Função main para testar localmente
    public static void main(String[] args) {
        EntregaController controller = new EntregaController();

        // Testando a criação de uma entrega
        controller.createEntrega(1, 101);

        // Testando a busca de uma entrega por ID
        controller.getEntregaById(1);

        // Testando a listagem de todas as entregas
        controller.listAllEntregas();
    }
}
