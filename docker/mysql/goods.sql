EXPLAIN
select tg.id                        as id,
       tg.goods_main_image_url      as imagesUrl,
       tg.goods_title               as goodsName,
       tg.goods_sku                 as goodsSku,
       tg.goods_state               as goodState,
       tg.created_by                as createdBy,
       tgc.category_name            as goodsCategory,
       tcer.symbol                  as symbol,
       tags.amazon_country_id       as countryId,
       (
           select count(*)
           FROM `t_goods_variants` tgv
           where tg.id = tgv.goods_id
             and tgv.deleted = 'N') as goodsVariantsNum,
       tg.goods_price               as goodsPrice,
       tg.goods_create_type         as type,
       tg.created_time              as createTime,
       tg.goods_create_type         as goodsSource,
       tg.is_edit                   as isEdit,
       tg.is_put_on_the_shelf       as putOnTheShelf,
       tg.not_put_shelf_msg         as putErrorMsg
from (t_goods tg
    inner join t_amazon_goods_shop tags on tg.id = tags.goods_id
    inner join t_goods_category tgc on tg.category_id = tgc.id
    inner join t_amazon_site_country tasc on tasc.id = tags.amazon_country_id)
         inner join t_currency_exchange_rate tcer on tcer.en_name = tasc.default_currency_code
WHERE tg.tenant_id = '1420220867377889280'
  and tg.deleted = 'N'
  and is_confirm = 0
  and tags.deleted = 'N'
  and tgc.deleted = 'N'
GROUP BY tg.id,
         tg.created_time,
         tcer.symbol,
         tags.amazon_country_id
order by tg.created_time desc limit 0,
       10

EXPLAIN
select t1.id                   as id,
       t1.goods_main_image_url as imagesUrl,
       t1.goods_title          as goodsName,
       t1.goods_sku            as goodsSku,
       t1.goods_state          as goodState,
       t1.created_by           as createdBy,
       tgc.category_name       as goodsCategory,
       tcer.symbol             as symbol,
       tags.amazon_country_id  as countryId,
       t1.goodsVariantsNum     as goodsVariantsNum,
       t1.goods_price          as goodsPrice,
       t1.type                 as type,
       t1.created_time         as createTime,
       t1.goodsSource          as goodsSource,
       t1.is_edit              as isEdit,
       t1.is_put_on_the_shelf  as putOnTheShelf,
       t1.not_put_shelf_msg    as putErrorMsg
from (
         select tg.id,
                tg.goods_main_image_url,
                tg.goods_title,
                tg.goods_sku,
                tg.goods_state,
                tg.created_by,
                (
                    select count(*)
                    FROM `t_goods_variants` tgv
                    where tg.id = tgv.goods_id
                      and tgv.deleted = 'N') as goodsVariantsNum,
                tg.goods_price,
                tg.goods_create_type         as type,
                tg.created_time,
                tg.goods_create_type         as goodsSource,
                tg.is_edit,
                tg.is_put_on_the_shelf,
                tg.not_put_shelf_msg,
                tg.category_id
         from t_goods tg
         WHERE tg.tenant_id = '1420220867377889280'
           and tg.deleted = 'N'
           and tg.is_confirm = 0
         order by tg.created_time desc limit 0, 10) as t1
         inner join t_amazon_goods_shop tags on t1.id = tags.goods_id
         inner join t_goods_category tgc on t1.category_id = tgc.id
         inner join t_amazon_site_country tasc on tasc.id = tags.amazon_country_id
         inner join t_currency_exchange_rate tcer on tcer.en_name = tasc.default_currency_code
where tags.deleted = 'N'
  and tgc.deleted = 'N'



select tg.id                   as id,
       tg.goods_main_image_url as imagesUrl,
       tg.goods_title          as goodsName,
       tg.goods_sku            as goodsSku,
       tg.goods_state          as goodState,
       tg.created_by           as createdBy,
       tgc.category_name       as goodsCategory,
       tcer.symbol             as symbol,
       tags.amazon_country_id  as countryId,
       count(*)                as goodsVariantsNum,
       tg.goods_price          as goodsPrice,
       tg.goods_create_type    as type,
       tg.created_time         as createTime,
       tg.goods_create_type    as goodsSource,
       tg.is_edit              as isEdit,
       tg.is_put_on_the_shelf  as putOnTheShelf,
       tg.not_put_shelf_msg    as putErrorMsg
from (t_goods tg inner join t_amazon_goods_shop tags on tg.id = tags.goods_id and tags.deleted = 'N'
    inner join t_goods_variants tgv on tgv.goods_id = tg.id and tgv.deleted = 'N'
    inner join t_goods_category tgc on tg.category_id = tgc.id and tgc.deleted = 'N'
    inner join t_amazon_site_country tasc on tasc.id = tags.amazon_country_id)
         inner join t_currency_exchange_rate tcer on tcer.en_name = tasc.default_currency_code
    <
where
    >
    tg.tenant_id = #{tenantId
    , jdbcType= VARCHAR}
  and tg.deleted = 'N'
  and is_confirm=0
    <if test="siteId != null and siteId != ''"
    >
  and tags.amazon_site_id = #{siteId
    , jdbcType= VARCHAR}
    </if
    >
    <if test="countryId != null and countryId != ''"
    >
  and tags.amazon_country_id = #{countryId
    , jdbcType= VARCHAR}
    </if
    >
    <if test="goodsTitle != null and goodsTitle != ''"
    >
    <bind name ="goodsTitleVar" value ="'%' + goodsTitle + '%'"/
    >
  and tg.goods_title like #{goodsTitleVar
    , jdbcType= VARCHAR}
    </if
    >

    <if test="userName != null and userName != ''"
    >
    <bind name ="userNameVar" value ="'%' + userName + '%'"/
    >
  and tg.created_by like #{userNameVar
    , jdbcType= VARCHAR}
    </if
    >

    <if test="sku != null and sku != ''"
    >
    <bind name ="skuVar" value ="'%' + sku + '%'"/
    >
  and tg.goods_sku like #{skuVar
    , jdbcType= VARCHAR}
    </if
    >
    <if test="sourceType != null"
    >
  and tg.goods_create_type = #{sourceType
    , jdbcType= VARCHAR}
    </if
    >

    </
where >
GROUP BY tg.id, tg.created_time, tcer.symbol, tags.amazon_country_id
order by tg.created_time desc



SELECT tg.id,
       tg.goods_main_image_url,
       tg.goods_title,
       tg.goods_sku,
       tg.goods_state,
       tg.created_by,
       (
           SELECT count(*)
           FROM `t_goods_variants` tgv
           WHERE tg.id = tgv.goods_id
             AND tgv.deleted = 'N')                           AS goodsVariantsNum,
       tg.goods_price,
       tg.goods_create_type                                   AS type,
       tg.created_time,
       tags.amazon_country_id,
       tgc.category_name,
       tg.goods_create_type                                   AS goodsSource,
       (
           select `symbol`
           from `t_currency_exchange_rate` tcer
           WHERE tasc.default_currency_code = tcer.`en_name`) AS symbol,
       tg.is_edit,
       tg.is_put_on_the_shelf,
       tg.not_put_shelf_msg,
       tg.category_id,
       tasc.default_currency_code
FROM t_goods tg
         INNER JOIN t_amazon_goods_shop tags ON tg.id = tags.goods_id
         INNER JOIN t_goods_category tgc ON tg.category_id = tgc.id
         INNER JOIN t_amazon_site_country tasc ON tasc.id = tags.amazon_country_id
WHERE tg.tenant_id = '1420220867377889280'
  AND tg.deleted = 'N'
  AND tg.is_confirm = 0
ORDER BY tg.created_time DESC LIMIT 1,
       10