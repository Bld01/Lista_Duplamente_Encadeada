public class Main {
    public static void main(String[] args) {
        ListaEncad lista = new ListaEncad();

        lista.add(5);
        lista.add(1);
        lista.add("s");
        lista.set(0, 10);
        lista.remove(1);
        lista.printList();

        System.out.println("Tamanho da lista: " + lista.getSize());
        System.out.println("Valor do item na posição 0: " + lista.get(0));
    }
}