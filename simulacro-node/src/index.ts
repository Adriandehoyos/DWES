/**
 * PASO 1: Configurar variables de entorno
 * IMPORTANTE: Esto DEBE ir al principio, antes de cualquier otro import
 */
import dotenv from 'dotenv';
dotenv.config();  // Lee el archivo .env y carga las variables

/**
 * PASO 2: Importar dependencias
 */
import express from 'express';              // Framework web
import sequelize from './config/database';  // Conexión a la base de datos

/**
 * PASO 3: Importar las rutas
 */
import libroRoutes from './routes/libroRoutes';
import usuarioRoutes from './routes/usuarioRoutes';
import prestamoRoutes from './routes/prestamoRoutes';

/**
 * PASO 4: Crear la aplicación Express
 */
const app = express();
const PORT = 3000;  // Puerto en el que correrá el servidor

/**
 * PASO 6: Ruta de prueba
 * GET http://localhost:3000/ para verificar que el servidor funciona
 */
app.get('/', (req, res) => {
  res.send('Servidor funcionando correctamente');
});

/**
 * PASO 7: Probar conexión a la base de datos
 * authenticate() intenta conectarse a MySQL con las credenciales del .env
 */
sequelize
  .authenticate()
  .then(() => console.log('✅ Conexión a la base de datos exitosa'))
  .catch((error) => console.error('❌ Error al conectar la base de datos:', error));

/**
 * PASO 8: Registrar las rutas
 * Todas las rutas empezarán con /api
 * Ejemplos:
 * - POST http://localhost:3000/api/libros
 * - GET http://localhost:3000/api/usuarios
 * - DELETE http://localhost:3000/api/prestamos/1
 */
app.use('/api', libroRoutes);
app.use('/api', usuarioRoutes);
app.use('/api', prestamoRoutes);

/**
 * PASO 9: Iniciar el servidor
 * El servidor escuchará peticiones en http://localhost:3000
 */
app.listen(PORT, () => {
  console.log(`🚀 Servidor corriendo en http://localhost:${PORT}`);
});