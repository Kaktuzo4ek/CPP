package Lab;

import java.util.*;

class Prima {
    private static int V ;
    public Prima(int number){
        V=number;
    }
    public List<Double> weigth = new ArrayList<>();

    // Функція для пошуку вершини з мінімальним ключем значення з набору вершин, які ще не включені в MST
    int minKey(int key[], Boolean mstSet[]) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }

    void printMST(int parent[], Integer graph[][]) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }


    // Функція для побудови та друку MST для представленого графа
    // використання матричного представлення суміжності
    Map<Integer, Map<Integer, Double>> primMST(Integer graph[][]) {
        // Масив для зберігання побудованого MST
        int parent[] = new int[V];

        // Ключові значення, що використовуються для вибору ребра мінімальної ваги
        int key[] = new int[V];

        // Для представлення набору вершин, включених до MST
        Boolean mstSet[] = new Boolean[V];

        // Ініціалізуємо всі ключі як безкінечні
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        // Завжди включати першу 1-у вершину в MST.
        key[0] = 0;// Зробити ключ 0, щоб ця вершина була обрана як перша вершину
        parent[0] = -1;// Перший вузол завжди є коренем MST

        // MST буде мати V вершин
        for (int count = 0; count < V - 1; count++) {

            // Вибираємо мінімальну ключову вершину з набору вершин ще не включено в MST
            int u = minKey(key, mstSet);

            // Додаємо вибрану вершину до набору MST
            mstSet[u] = true;

            // Оновлення значення ключа та батьківського індексу суміжної
            // вершини виділеної вершини. Розглянемо лише ті
            // вершини, які ще не включені в MST
            for (int v = 0; v < V; v++)

                // graph[u][v] відмінний від нуля тільки для сусідніх вершин m
                // mstSet[v] є хибним для вершин, які ще не включені в MST
                // Оновлюємо ключ, лише якщо graph[u][v] менший за key[v]
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }
        printMST(parent, graph);
        Map<Integer, Map<Integer, Double>> map = new HashMap<>();
        for (int i = 1; i < V; i++) {
            Map<Integer, Double> map1 = new TreeMap<>();
            weigth.add(Double.valueOf(graph[i][parent[i]]));
            map1.put(i, Double.valueOf(graph[i][parent[i]]));
            if (map.containsKey(parent[i])) {
                Map<Integer, Double> temp = new TreeMap<>();

                for (Map.Entry<Integer, Map<Integer, Double>> entry : map.entrySet()
                ) {
                    if (entry.getKey().equals(parent[i])) {
                        temp = entry.getValue();
                    }
                }
                temp.putAll(map1);
            } else map.put(parent[i], map1);
        }
        System.out.println(map);
        return map;
    }
}