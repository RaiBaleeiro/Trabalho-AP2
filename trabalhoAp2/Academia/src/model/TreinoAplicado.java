package model;

public class TreinoAplicado extends Treino {
    private String treino;

    public TreinoAplicado(String nivel) { super(nivel); }

    public String getTreino() {
        return treino;
    }

    public void setTreino(String treino) {
        this.treino = treino;
    }

    public String treinoDoDia() {
      if (this.getNivel().equals("INICIANTE")) {
        switch (this.getDia()) {
          case "A":
            setTreino("Voador frontal máquina 3x12" +
              "\nSupino inclinado articulado 3x12" +
              "\nPeck deck 3x12" +
              "\nSupino declinado 3x12" +
              "\nTríceps polia alta 3x15" +
              "\nTríceps testa 3x12" +
              "\nTríceps corda 3x15"
            );
            break;
          case "B":
            setTreino("Puxador 3x12" +
              "\nRemada baixa 3x12" +
              "\nRemada alta 3x12" +
              "\nCrucifixo inverso 3x12" +
              "\nRosca alternada 3x12" +
              "\nBíceps concentrado 3x12" +
              "\nRosca barra H 3x12"
            );
            break;
          case "C":
            setTreino("Desenvolvimento 3x12" +
              "\nElevação lateral 3x12" +
              "\nLeg press 45° 3x20" +
              "\nAgachamento sumô 3x20" +
              "\nCadeira extensora 3x20" +
              "\nCadeira flexora 3x20" +
              "\nAbdutor 3x20" +
              "\nAdutor 3x20" +
              "\nExtensão de quadril com caneleira 3x20" +
              "\nFlexão plantar na máquina 3x20"
            );
            break;
        }
      } else {
        switch (this.getDia()) {
        case "A":
          setTreino("Supino reto 3x12" +
            "\nSupino inclinado 3x12" +
            "\nCrucifixo halter 3x12" +
            "\nCrossover 3x12 (falha)" +
            "\nTríceps polia alta 3x15" +
            "\nTríceps testa polia 3x12 (falha)" +
            "\nTríceps corda 4x12 (falha)"
          );
          break;
        case "B":
          setTreino("Puxador 3x12" +
            "\nLevantamento terra 3x12" +
            "\nRemada alta 3x12 (falha)" +
            "\nPuxador polia 3x12 (falha)" +
            "\nRosca direta peso livre 3x12 (falha)" +
            "\nRosca Scott 4x8 (falha)" +
            "\nRosca banco inclicado 3x12 (falha)"
          );
          break;
        case "C":
          setTreino("Desenvolvimento 3x12" +
            "\nElevação lateral 3x12" +
            "\nAgachamento Hack 4x12" +
            "\nAgachamento búlgaro" +
            "\nCadeira extensora 4x12 (falha)" +
            "\nCadeira flexora 4x12 (falha)" +
            "\nAbdutor 3x12" +
            "\nAdutor 3x12" +
            "\nPanturrilha leg press 4x12 (falha)"
          );
          break;
      }
    }
    return this.treino;
  }
}
