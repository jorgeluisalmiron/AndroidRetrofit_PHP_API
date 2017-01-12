<?php

/**
* Representa el la estructura de las Links
* almacenados en la base de datos
*/

class Test
{
  function __construct()
  {
  }


  public static function getAll()
  {
    $consulta = "SELECT * FROM testAPI";
    try {
      // Preparar sentencia
      $comando = Database::getInstance()->getDb()->prepare($consulta);
      // Ejecutar sentencia preparada
      $comando->execute();

      return $comando->fetchAll(PDO::FETCH_ASSOC);

    } catch (PDOException $e) {
      return false;
    }
  }


  public static function getById($id)
  {
    // Consulta de la tabla Links
    $consulta = "SELECT id,
    nombre,
    direccion
    FROM testAPI
    WHERE id = ?";

    try {
      // Preparar sentencia
      $comando = Database::getInstance()->getDb()->prepare($consulta);
      // Ejecutar sentencia preparada
      $comando->execute(array($id));
      // Capturar primera fila del resultado
      $row = $comando->fetch(PDO::FETCH_ASSOC);
      return $row;

    } catch (PDOException $e) {
      // Aqu� puedes clasificar el error dependiendo de la excepci�n
      // para presentarlo en la respuesta Json
      return -1;
    }
  }


  public static function update(
    $id,
    $nombre,
    $direccion
    )
    {
      // Creando consulta UPDATE


      $consulta = "UPDATE testAPI" .
      " SET nombre=?, direccion=? " .
      "WHERE id=?";

      // Preparar la sentencia
      $cmd = Database::getInstance()->getDb()->prepare($consulta);


      // Relacionar y ejecutar la sentencia
      $cmd->execute(array($nombre, $direccion, $id));

      return $cmd;


    }


    public static function insert(
      $id,
      $nombre,
      $direccion
      )
      {
        // Sentencia INSERT
        $comando = "INSERT INTO testAPI ( " .
        "nombre," .
        " direccion)" .
        " VALUES(?,?)";

        // Preparar la sentencia
        $sentencia = Database::getInstance()->getDb()->prepare($comando);

        return $sentencia->execute(
          array(
            $nombre,
            $direccion
          )
        );

      }


      public static function delete($id)
      {
        // Sentencia DELETE
        $comando = "DELETE FROM testAPI WHERE id=?";

        // Preparar la sentencia
        $sentencia = Database::getInstance()->getDb()->prepare($comando);

        return $sentencia->execute(array($id));
      }
    }

    class TestAPI
    {
      function __construct()
      {
      }

      function getAll(){
        if ($_SERVER['REQUEST_METHOD'] == 'GET') {

          // Manejar petici�n GET
          $Links = Test::getAll();

          if ($Links) {

            $datos["errorCode"] = 0;
            $datos["errorMessage"] = "OK";
            $datos["results"] = $Links;
            header('Content-type: application/json');
            print json_encode($datos);
          }
          else {
            $datos["errorCode"] = 1;
            $datos["errorMessage"] = "PHP - Error al consultar";
            $datos["results"] = array('');
            header('Content-type: application/json');
            print json_encode($datos);
          }
        }
      }

      function getById(){

        if ($_SERVER['REQUEST_METHOD'] == 'GET') {

            if (isset($_GET['id'])) {

                // Obtener par�metro idalumno
                $parametro = $_GET['id'];

                // Tratar retorno
                $retorno = Test::getById($parametro);


                if ($retorno) {

                    $datos["errorCode"] = 0;
                    $datos["errorMessage"] = "OK";
                    $datos["results"] = array($retorno);
                    header('Content-type: application/json');
                    print json_encode($datos);
                }
                else {
                    $datos["errorCode"] = 1;
                    $datos["errorMessage"] = "PHP - Error al consultar";
                    $datos["results"] = array();
                    header('Content-type: application/json');
                    print json_encode($datos);
                }
             }
             else {
                   $datos["errorCode"] = 2;
                   $datos["errorMessage"] = "PHP - Se necesita un identificador";
                   $datos["results"] = array();
                   header('Content-type: application/json');
                   print json_encode($datos);
              }

        }
      }

      function insert()
      {
        if ($_SERVER['REQUEST_METHOD'] == 'POST') {

            // Decodificando formato Json
            $body = json_decode(file_get_contents("php://input"), true);

            // Insertar Alumno
            $retorno = Test::insert(
                $body['id'],
                $body['nombre'],
                $body['direccion']);

            if ($retorno) {

              $datos["errorCode"] = 0;
              $datos["errorMessage"] = "OK";
              header('Content-type: application/json');
              $json_string = json_encode($datos);
        	  	echo $json_string;
            }
            else {

              $datos["errorCode"] = 1;
              $datos["errorMessage"] = "PHP - Error al crear el registro ";
              header('Content-type: application/json');
              $json_string = json_encode($datos);
              echo $json_string;
            }
        }
      }

      function update(){
        if ($_SERVER['REQUEST_METHOD'] == 'PUT') {

            // Decodificando formato Json

            $body = json_decode(file_get_contents("php://input"), true);

            // Actualizar alumno
            $retorno = Test::update(
            $body['id'],
            $body['nombre'],
            $body['direccion']);

            if ($retorno) {

                  $datos["errorCode"] = 0;
                  $datos["errorMessage"] = "OK";
                  header('Content-type: application/json');
                  $json_string = json_encode($datos);
            	  	echo $json_string;
                }
                else {

                  $datos["errorCode"] = 1;
                  $datos["errorMessage"] = "PHP - Error al actualizar el registro ";
                  header('Content-type: application/json');
                  $json_string = json_encode($datos);
                  echo $json_string;
                }

            }
      }

      function delete()
      {
        if ($_SERVER['REQUEST_METHOD'] == 'DELETE') {

          if (isset($_GET['id'])) {

            // Obtener par�metro idalumno
            $parametro = $_GET['id'];
            // Decodificando formato Json
            $body = json_decode(file_get_contents("php://input"), true);
            $retorno = Test::delete($parametro);

            //$json_string = json_encode($clientes);
            //echo 'antes de entrar';
            if ($retorno) {

              $datos["errorCode"] = 0;
              $datos["errorMessage"] = "OK";
              header('Content-type: application/json');
              $json_string = json_encode($datos);
              echo $json_string;
            }
            else {

              $datos["errorCode"] = 1;
              $datos["errorMessage"] = "PHP - Error al eliminar el registro ";
              header('Content-type: application/json');
              $json_string = json_encode($datos);
              echo $json_string;
            }
          }
          else {
            $datos["errorCode"] = 2;
            $datos["errorMessage"] = "PHP - Parametro incorrecto";
            header('Content-type: application/json');
            $json_string = json_encode($datos);
            echo $json_string;

            }
          }
      }
    }
    ?>
