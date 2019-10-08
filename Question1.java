@Component
public class InvoiceServiceLayer {
  
  ItemDao itemDaoImpl;
  
  @Autowired
  public InvoiceServiceLayer(ItemDao itemDaoImpl) {
    this.itemDaoImpl = itemDaoImpl;
  }
  
  public InvoiceLineItem generateInvoiceLineItem(PurchaseOrder po) {
    // CODE GOES HERE
    /* 
    - create new InvLineItem to store and return calculated values
    - would usually prefer to create a method to calculate, but this is one time use so I can perform inline calculations. 
    - Notes: 
    - User passes item Id in Purchase Order, retrieve it from ItemDaoImpl
    - multiply price by quantity from p.o
    */
    InvoiceLineItem invoiceLineItem = new InvoiceLineItem();

    Item item = itemDaoImpl.findById(po.getItemId());
   
    int total = item.getPrice() * po.getQuantity();
    
    invoiceLineItem.setDescription(item.getDescription());
    invoiceLineItem.setTotal(total);
    
    return invoiceLineItem;
  }
}