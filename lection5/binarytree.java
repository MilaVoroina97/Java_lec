package lection5;

import java.util.Stack;

class Node{
        private int value;//ключ узла
        private Node leftChild;
        private Node rigthChild;

        public void printNode(){
            System.out.println("Выбранный узел имеет значение : " + value);
        }

        public int getValue(){
            return this.value;
        }

        public void setValue(final int value){
            this.value = value;
        }

        public Node getLeftChild(){
            return this.leftChild;
        }

        public void setLeftChild(final Node leftChild){
            this.leftChild = leftChild;
        }

        public Node getRightChild(){
            return this.rigthChild;
        }

        public void setRightChild(final Node rightChild){
            this.rigthChild = rightChild;
        }

        @Override
        public String toString(){
            return "Node{" + "value = " + value +" , "+ "leftChild = " + leftChild + " , " + "rightChild = " + rigthChild + "}"; 
        }

    }

    class Tree{
        private Node rootNode;
        public Tree(){
            rootNode = null;
        }

        public Node findNodebyValue(int value){
            Node currentNode = rootNode;
            while(currentNode.getValue() != value){
                if(value< currentNode.getValue()){
                    currentNode = currentNode.getLeftChild();
                }else{
                    currentNode = currentNode.getRightChild();
                }if(currentNode == null){
                    return null;
                }
            }

            return currentNode;

        }

        public void insertNode(int value){
            Node newNode = new Node();
            newNode.setValue(value);
            if(rootNode == null){
                rootNode = newNode;
            }else{
                Node currentNode = rootNode;
                Node parentNode;
                while(true){
                    parentNode = currentNode;
                    if(value == currentNode.getValue()){//если такое элемент уже есть , то не сохраняем его
                        return;
                    }else if(value < currentNode.getValue()){
                        currentNode = currentNode.getLeftChild();
                        if(currentNode == null){// если был достигнуть конец цепочки
                            parentNode.setLeftChild(newNode);
                            return;
                        }
                    }else{
                        currentNode = currentNode.getRightChild();
                        if(currentNode == null){
                            parentNode.setRightChild(newNode);
                            return;
                        }
                    }
                }
            }
        }

        public boolean deleteNode(int value){
            Node currentNode = rootNode;
            Node parentNode = rootNode;
            boolean isLeftChild = true;
            while(currentNode.getValue() != value){
                parentNode = currentNode;
                if(value < currentNode.getValue()){
                    isLeftChild = true;
                    currentNode = currentNode.getLeftChild();
                }else{
                    isLeftChild = false;
                    currentNode = currentNode.getRightChild();
                }if (currentNode == null){
                    return false;
                }
            }
            if(currentNode.getLeftChild() == null && currentNode.getRightChild() == null){//если нет потомков,то мы просто удаляем узел
                if(currentNode == rootNode){//если узел - корень, то дерево очищается
                    rootNode = null;
                }else if(isLeftChild){//если нет - отсоединяем узел от родителя
                    parentNode.setLeftChild(null);
                }else{
                    parentNode.setRightChild(null);
                }
            }

            else if(currentNode.getRightChild() == null){//узел заменяется левым поддеревом, если правого нет
                if(currentNode == rootNode){
                    rootNode = currentNode.getLeftChild();
                }else if(isLeftChild){
                    parentNode.setLeftChild(currentNode.getLeftChild());
                }else{
                    parentNode.setRightChild(currentNode.getLeftChild());
                }
            }else if(currentNode.getLeftChild() == null){
                if(currentNode == rootNode){
                    rootNode = currentNode.getRightChild();
                }else if(isLeftChild){
                    parentNode.setLeftChild(currentNode.getRightChild());
                }else{
                    parentNode.setRightChild(currentNode.getRightChild());
                }
            }else{//если два потомка, замена узла преемников
                Node heir = receiveHeir(currentNode);
                if(currentNode == rootNode){
                    rootNode = heir;
                }else if(isLeftChild){
                    parentNode.setLeftChild(heir);
                }else{
                    parentNode.setRightChild(heir);
                }
            }
            return true;
        }

        private Node receiveHeir(Node node){//метод, который возвращает узел со след значением после передаваемого аргументом,
            //для начала переходим к правому потомку, а потом ищем среди левых потомков правого узла
            Node parentNode = node;
            Node heirNodet = node;
            Node currentNode = node.getRightChild();
            while(currentNode != null){//пока остаются левые потомки
                parentNode = heirNodet;//задаем потомка как текущий узел
                heirNodet = currentNode;
                currentNode = currentNode.getLeftChild();//переход к левому потомку
            }
            if(heirNodet != node.getRightChild()){//если преемник не является правым потоком - создаем связи между узлами 
                parentNode.setLeftChild(heirNodet.getRightChild());
                heirNodet.setRightChild(node.getRightChild());
            }

            return heirNodet;
        }

        public void PrintTree(){
            Stack<Node>globalStack = new Stack<>();//общий стэк для значений дерева
            globalStack.push(rootNode);
            int gasp = 2; //начальное значения для расстояния между элементами
            boolean isRowEmpty = false;
            String separator = "-----------------------------------------------------------------";
            System.out.println(separator);
            while(isRowEmpty == false){
                Stack<Node> localStack = new Stack<>();//локальный стэк для задания потомков элемента
                isRowEmpty = true;
                for(int j = 0 ; j < gasp; j++){
                    System.out.println(' ');
                }
                while(globalStack.isEmpty() == false){
                    Node temp = (Node) globalStack.pop();
                    if(temp != null){
                        System.out.println(temp.getValue());
                        localStack.push(temp.getLeftChild());
                        localStack.push(temp.getRightChild());
                        if(temp.getLeftChild() != null || temp.getRightChild() != null){
                            isRowEmpty = false;
                            }
                        }else{
                            System.out.println("__");
                            localStack.push(null);
                            localStack.push(null);
                        }

                        for(int k = 0; k < gasp *2 -2 ; k++){
                            System.out.println(' ');
                        }
                    }

                    System.out.println();
                    gasp /= 2;
                    while(localStack.isEmpty() == false){
                        globalStack.push(localStack.pop());
                    }
                    System.out.println(separator);
                }
            }


        }

        public class binarytree {
            public static void main(String[] args) {
                Tree tree = new Tree();
                // вставляем узлы в дерево:
                tree.insertNode(6);
                tree.insertNode(8);
                tree.insertNode(5);
                tree.insertNode(8);
                tree.insertNode(2);
                tree.insertNode(9);
                tree.insertNode(7);
                tree.insertNode(4);
                tree.insertNode(10);
                tree.insertNode(3);
                tree.insertNode(1);
                // отображение дерева:
                tree.PrintTree();
         
                // удаляем один узел и выводим оставшееся дерево в консоли
                // tree.deleteNode(5);
                // tree.PrintTree();
         
                // находим узел по значению и выводим его в консоли
                Node foundNode = tree.findNodebyValue(7);
                foundNode.printNode();
            }
         }
    

