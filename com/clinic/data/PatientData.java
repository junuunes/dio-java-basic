package com.clinic.data;

import java.time.*; //Importa classes para manipulação de datas e horas
import java.time.format.DateTimeFormatter; // Importa classe para formatar datas
import java.util.Scanner; // Importa a classe Scanner para entrada de dados do usuário

// Classe que representa os dados do paciente
public class PatientData {
    // Declaração dos atributos privados do paciente
    private final String name;              // Nome do paciente
    private final String gender;            // Gênero (M/F)
    private final LocalDateTime date_of_birth; // Data e hora de nascimento do paciente
    private final String mother;            // Nome da mãe
    private final  String father;            // Nome do pai
    private final String place_of_birth;    // Cidade de nascimento
    private final String brazilian_state;   // Estado brasileiro onde nasceu
    private final String blood_type;        // Tipo sanguíneo

    // Construtor da classe que inicializa os atributos do paciente
    public PatientData(String name, String gender, LocalDateTime date_of_birth,
                       String mother, String father, String place_of_birth,
                       String brazilian_state, String blood_type) {
        this.name = name;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.mother = mother;
        this.father = father;
        this.place_of_birth = place_of_birth;
        this.brazilian_state = brazilian_state;
        this.blood_type = blood_type;
    }

    //Método que calcula a idade exata do paciente (anos, meses, dias, horas, minutos)
    public String getExactAge() {
        LocalDateTime now = LocalDateTime.now(); // Obtém a data e hora atuais
        Period period = Period.between(date_of_birth.toLocalDate(), now.toLocalDate());
        // Calcula a diferença em anos, meses e dias entre a data de nascimento e hoje

        Duration duration = Duration.between(date_of_birth, now);
        // Calcula a diferença exata em tempo (incluindo horas e minutos)

        long hours = duration.toHoursPart();   // Obtém as horas exatas de diferença
        long minutes = duration.toMinutesPart(); // Obtém os minutos exatos de diferença

        // Retorna a idade formatada com anos, meses, dias, horas e minutos
        return period.getYears() + " years, " + period.getMonths() + " months, " + period.getDays() + " days, " +
                hours + " hours, " + minutes + " minutes";
    }

    // Método que retorna a data de nascimento formatada
    public String getFormattedBirthDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
        // Define o formato da data (mês/dia/ano horas:minutos)

        return this.date_of_birth.format(formatter); // Formata e retorna a data formatada como string
    }

    // Método toString() para exibir os dados do paciente de forma organizada
    @Override
    public String toString() {
        return "\n📌 Patient Information\n" +
                "--------------------------------\n" +
                "Name: " + name + "\n" +
                "📅 Date of Birth: " + getFormattedBirthDate() + "\n" +
                "🎂 Age: " + getExactAge() + "\n" +
                "⚧ Gender: " + gender + "\n" +
                "👩 Mother: " + mother + "\n" +
                "👨 Father: " + father + "\n" +
                "📍 Place of Birth: " + place_of_birth + ", " + brazilian_state + "\n" +
                "🩸 Blood Type: " + blood_type + "\n" +
                "--------------------------------";
    }

    // Método principal (entry point) do programa
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria um objeto Scanner para capturar entrada do usuário
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
        // Define o formato de entrada da data

        // Captura os dados do usuário
        System.out.print("Enter name: ");
        String name = scanner.nextLine(); // Lê o nome do usuário

        System.out.print("Enter date of birth (MM/dd/yyyy HH:mm): ");
        LocalDateTime date_of_birth = LocalDateTime.parse(scanner.nextLine(), formatter);
        // Converte a string digitada pelo usuário para um objeto LocalDateTime no formato correto

        System.out.print("Enter gender (M/F): ");
        String gender = scanner.nextLine(); // Lê o gênero do usuário

        System.out.print("Enter mother's name: ");
        String mother = scanner.nextLine(); // Lê o nome da mãe

        System.out.print("Enter father's name: ");
        String father = scanner.nextLine(); // Lê o nome do pai

        System.out.print("Enter place of birth: ");
        String place_of_birth = scanner.nextLine(); // Lê a cidade de nascimento

        System.out.print("Enter state (abbreviation): ");
        String brazilian_state = scanner.nextLine(); // Lê o estado de nascimento

        System.out.print("Enter blood type: ");
        String blood_type = scanner.nextLine(); // Lê o tipo sanguíneo

        // Cria um objeto com.clinic.data.PatientData com os dados capturados
        PatientData patient = new PatientData(name, gender, date_of_birth, mother, father, place_of_birth, brazilian_state, blood_type);

        // Exibe as informações do paciente
        System.out.println(patient);

        // Fecha o Scanner para evitar vazamento de recursos
        scanner.close();
    }
}
