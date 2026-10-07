//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    Set<Pessoa> banco = new HashSet<>();

    banco.add(new Pessoa(1, "Angélica", 28));
    banco.add(new Pessoa(2, "Jade", 42));
    banco.add(new Pessoa(3, "Isabella", 19));
    banco.add(new Pessoa(4, "Fiama", 23));
    banco.add(new Pessoa(5, "Carlos", 35));

    Set<Pessoa> cache = new LinkedHashSet<>();

    Scanner scanner = new Scanner(System.in);

    IO.println("Digite o id do usuario que deseja buscar no banco:");
    int idBusca = scanner.nextInt();

    while (idBusca != 0) {

        Pessoa pessoaEncontrada = null;

        for (Pessoa pessoa : cache) {
            if (pessoa.getId() == idBusca) {
                pessoaEncontrada = pessoa;
                break;
            }
        }

        if (pessoaEncontrada != null) {
            IO.println("Pessoa encontrada no cache: " + pessoaEncontrada);
        } else {
            for (Pessoa pessoa : banco) {
                if (pessoa.getId() == idBusca) {
                    pessoaEncontrada = pessoa;
                    break;
                }
            }

            if (pessoaEncontrada != null) {
                if (cache.size() >= 10) {
                    Pessoa maisAntiga = cache.iterator().next();
                    cache.remove(maisAntiga);
                    IO.println("[Cache está cheio] Removido do cache: " + maisAntiga.getNome());
                }

                cache.add(pessoaEncontrada);
                IO.println("Pessoa buscada no banco e adicionada ao cache: " + pessoaEncontrada);
            } else {

                IO.println("Pessoa com ID " + idBusca + " não foi encontrada.");
                IO.println("Vamos cadastrá-la agora.");

                scanner.nextLine();

                IO.println("Digite o nome:");
                String nome = scanner.nextLine();

                IO.println("Digite a idade:");
                int idade = scanner.nextInt();

                Pessoa novaPessoa = new Pessoa(idBusca, nome, idade);

                if (cache.size() >= 10) {
                    Pessoa maisAntiga = cache.iterator().next();
                    cache.remove(maisAntiga);
                    IO.println("[Cache está cheio] Removido do cache: " + maisAntiga.getNome());
                }

                cache.add(novaPessoa);
                IO.println("Pessoa cadastrada e adicionada ao cache: " + novaPessoa);
            }
        }

        IO.println("\nDigite o id do usuario que deseja buscar (ou 0 para sair):");
        idBusca = scanner.nextInt();
    }

    IO.println("Busca finalizada!");
}