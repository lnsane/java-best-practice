# 删除节点所有内容

```genericsql
MATCH (n) OPTIONAL MATCH (n)-[r]-() DELETE
r,n
```
