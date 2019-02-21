#Source

    https://developer.lightbend.com/guides/akka-distributed-workers-scala/index.html

    ## inicie la base de datos de Cassandra
    sbt "runMain worker.Main cassandra"
    La base de datos de Cassandra permanecerá viva mientras no elimines este proceso, cuando quieras detenerlo, puedes hacerlo con Ctrl + C. Sin la base de datos, los nodos de back-end no podrán iniciarse.

    ## primer nodo inicial
    sbt "runMain worker.Main 2551"
    2551 corresponde al puerto del primer elemento semilla-nodos en la configuración. En la salida del registro, verá que el nodo del clúster se ha iniciado y se ha cambiado el estado a 'Arriba'.

    ## front-end
    sbt "runMain worker.Main 3001"
    3001 es al puerto del nodo. En la salida del registro, verá que el nodo del clúster se ha iniciado, se une al nodo 2551 y se convierte en miembro del clúster. Su estado cambió a 'Arriba'.

    ## nodo de trabajador
    sbt "runMain worker.Main 5001 3"
    5001 significa que el nodo será un nodo trabajador, y el segundo parámetro 3significa que hospedará a tres actores trabajadores.
    Mire la salida de registro en las diferentes ventanas de terminal. En la segunda ventana (front-end) debería ver que los trabajos producidos se procesan y se registran como "Consumed result".