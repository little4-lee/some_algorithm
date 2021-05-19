package linkedlist;

public class LruCache {
    private ListNode mSoldier = new ListNode(0);
    private int mCount = 0;

    private static final int DEFAULT_CACHE_SIZE = 10;
    private final int mCacheSize;

    public LruCache () {
        this.mCacheSize = DEFAULT_CACHE_SIZE;
    }

    public LruCache (int cacheSize) {
        this.mCacheSize = cacheSize;
    }

    public void put (int val) {

        ListNode p = mSoldier.next;
        ListNode pre = mSoldier;
        boolean cached = false;
        while (p != null) {
            if (p.val == val) {
                cached = true;
                remove(pre, p);
                addToHead(val);
                break;
            }
            pre = p;
            p = p.next;
        }

        if (cached) return;

        if (mCount == mCacheSize) removeTail();
        addToHead(val);
    }

    private void removeTail () {
        ListNode p = mSoldier.next;
        if (p == null) return;

        ListNode pre = mSoldier;
        while (p.next != null) {
            pre = p;
            p = p.next;
        }
        remove(pre, p);
    }

    private void addToHead (int val) {
        ListNode node = new ListNode(val);
        node.next = mSoldier.next;
        mSoldier.next = node;
        mCount++;
    }

    public void remove (int val) {
        ListNode p = mSoldier.next;
        ListNode pre = mSoldier;
        while (p != null) {
            if (p.val == val) {
                remove(pre, p);
            }
            pre = p;
            p = p.next;
        }
    }

    private void debugList() {
        NodeUtils.printList(mSoldier.next);
        System.out.println();
    }

    private void remove (ListNode pre, ListNode toDelete) {
        pre.next = toDelete.next;
        toDelete.next = null;
        mCount--;
    }

    public static void main (String[] args) {
        // TODO: 2021/5/19
        LruCache lru = new LruCache(3);
        lru.put(1);
        lru.debugList();

        lru.put(2);
        lru.debugList();

        lru.put(3);
        lru.debugList();

        lru.put(4);
        lru.debugList();

        lru.put(1);
        lru.debugList();


        lru.remove(1);
        lru.debugList();

        lru.remove(2);
        lru.debugList();

    }
}
