# SpringTest5
to be continue


Web, DevTools, JPA, postgresql, Thymeleaf 

Item, Vendor, Characteristic, Specification, Price

@Column(name = "vendor_code", unique = true)
@NotNull
    
@ManyToOne
@OnDelete(action = OnDeleteAction.CASCADE)
@JoinColumn(name="vendor_id")
@NotNull
    
@Table(name="items_price",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"item_id", "vendor_id"})})

@PathVariable Integer id, @ModelAttribute Item item

@GetMapping("vendors/new")
@PostMapping("vendors/new")
return "redirect:/vendors";
