package cn.dodo.structure.linkedList;

/**
 * 环形双向列表
 *
 */
public class DoubleLinkedList {

    public static void main(String[] args) {

        HeroNode node = new HeroNode("1","刘德华");
        HeroNode node2 = new HeroNode("2","周润发");
        HeroNode node3 = new HeroNode("3","周星星");
        DoubleLinkedList list = new DoubleLinkedList();
        list.add(node);
        list.add(node2);
        list.add(node3);
        list.delete("2");
        list.show();

    }

    private HeroNode first;

    private HeroNode last;

    /**
     * 链表添加
     *
     *
     */
    public boolean add(HeroNode heroNode){
        addLast(heroNode);
        return true;
    }
    private void addLast(HeroNode heroNode) {
         final HeroNode e = last;
         last = heroNode;
         if(e == null){
             first =heroNode;
             first.setNext(last);
             first.setPre(last);
         }else{
             e.setNext(last);
             last.setPre(e);
             last.setNext(first);
             first.setPre(last);
         }
    }
    //修改
    public void update(HeroNode heroNode){
        if(first == null && last == null){
            throw new RuntimeException("链表为空");
        }
        HeroNode temp = first;
        while(true){
            if(check(temp.getNo(),heroNode.getNo())){
                temp.setName(heroNode.getName());
                break;
            }
            if(temp.getNext() == first)
                break;
            temp = temp.getNext();

        }

    }
    private Boolean check(String no,String anotherNo){
        return no.equals(anotherNo);
    }

    //删除
    public void delete(String no){
        if(first == null && last == null){
            throw new RuntimeException("链表为空");
        }
        for(HeroNode temp = first ; temp.getNext() != first;temp = temp.getNext()){
            if(check(temp.getNo(),no)){
                temp.getPre().setNext(temp.getNext());
                temp.getNext().setPre(temp.getPre());
                break;
            }

        }
    }

    //遍历
    public void show(){
        if(first == null && last == null){
             throw new RuntimeException("链表为空");
        }
        HeroNode temp = first;
        while(true){
            if(last == temp){
                System.out.println("信息-last:"+last);
                break;
            }
            System.out.println("信息:"+temp);
            temp = temp.getNext();
        }
    }





    private static class HeroNode{

        private String no;

        private String name;

        private HeroNode pre;

        private HeroNode next;

        public HeroNode(String no, String name) {
            this.no = no;
            this.name = name;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public HeroNode getPre() {
            return pre;
        }

        public void setPre(HeroNode pre) {
            this.pre = pre;
        }

        public HeroNode getNext() {
            return next;
        }

        public void setNext(HeroNode next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no='" + no + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

}





