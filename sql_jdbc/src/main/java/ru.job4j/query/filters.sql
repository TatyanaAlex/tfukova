-- 1.Написать запрос получение всех продуктов с типом "СЫР"

select * from product as p where p.type_id = (select id from type where name = 'сыр');

--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"

 select * from product where name like '%мороженное%';

--3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.

SELECT p.name, p.price, p.expired_date
FROM
t_product AS p
WHERE
p.expired_date BETWEEN date_trunc('MONTH', CURRENT_TIMESTAMP + '1 month'::INTERVAL)
AND date_trunc('MONTH', CURRENT_TIMESTAMP) + '2 MONTH'::INTERVAL - '1 DAY'::INTERVAL;

--4. Написать запрос, который выводит самый дорогой продукт.

select * from product where price = (select max(price) from product);

--5. Написать запрос, который выводит количество всех продуктов определенного типа.

select count(id) from product where type_id = 1;

--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"

select * from product where type_id = (select id from type where name = 'сыр')
or type_id = (select id from type where name ='молоко');
