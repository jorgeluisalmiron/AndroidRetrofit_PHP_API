<?php
require 'flight/Flight.php';
require_once 'Database.php';
require 'Youtube.php';
require 'Links.php';
require 'TestAPI.php';

Flight::route('/', function(){
    echo 'TEST API REST';
});


/*TEST API*/
Flight::route('/test/getAll', function(){

  $object = new TestAPI();
  $object->getAll();
  unset($object);
});

Flight::route('/test/getbyId', function(){

  $object = new TestAPI();
  $object->getbyId();
  unset($object);
});

Flight::route('/test/insert', function(){

  $object = new TestAPI();
  $object->insert();
  unset($object);
});

Flight::route('/test/update', function(){

  $object = new TestAPI();
  $object->update();
  unset($object);
});

Flight::route('/test/delete', function(){

  $object = new TestAPI();
  $object->delete();
  unset($object);
});
/****************************************************************************************/


/*Youtube API*/
Flight::route('/youtube/getAll', function(){

  $object = new YoutubeAPI();
  $object->getAll();
  unset($object);
});

Flight::route('/youtube/getbyId', function(){

  $object = new YoutubeAPI();
  $object->getbyId();
  unset($object);
});

Flight::route('/youtube/insert', function(){

  $object = new YoutubeAPI();
  $object->insert();
  unset($object);
});

Flight::route('/youtube/update', function(){

  $object = new YoutubeAPI();
  $object->update();
  unset($object);
});

Flight::route('/youtube/delete', function(){

  $object = new YoutubeAPI();
  $object->delete();
  unset($object);
});
/****************************************************************************************/



/*Links API*/
Flight::route('/links/getAll', function(){

  $object = new LinksAPI();
  $object->getAll();
  unset($object);
});

Flight::route('/links/getbyId', function(){

  $object = new LinksAPI();
  $object->getbyId();
  unset($object);
});

Flight::route('/links/insert', function(){

  $object = new LinksAPI();
  $object->insert();
  unset($object);
});

Flight::route('/links/update', function(){

  $object = new LinksAPI();
  $object->update();
  unset($object);
});

Flight::route('/links/delete', function(){

  $object = new LinksAPI();
  $object->delete();
  unset($object);
});
/****************************************************************************************/

Flight::start();
?>
