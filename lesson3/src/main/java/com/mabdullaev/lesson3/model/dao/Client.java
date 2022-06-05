package com.mabdullaev.lesson3.model.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "clients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@NamedNativeQueries(
        {
            @NamedNativeQuery(name = "GetClientsByProduct",
                query = "select " +
                        "    c.id, c.name " +
                        " from" +
                        "    clients c " +
                        " join orders ord " +
                        "    on (ord.client_id = c.id)" +
                        " join order_spec sp " +
                        "    on (sp.order_id = ord.id)" +
                        " join products p " +
                        "    on (p.id = sp.product_id)" +
                        " where " +
                        "    p.id = :product_id",
            resultClass = Client.class)
        }
        )
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
    private Set<Order> orders;

}