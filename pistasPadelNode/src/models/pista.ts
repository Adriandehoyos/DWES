import {DataTypes, Model } from "sequelize";
import sequelize from "../config/database";

class Pista extends Model {
public id!: number;
public nombre!: string;
public tipo!: string;
public precio_hora!: number;
}

Pista.init(
{
    id: {
        type: DataTypes.INTEGER,
        autoIncrement: true,
        primaryKey: true,
    },
    nombre: {
        type: DataTypes.STRING,
        allowNull: false,
        unique: true,
    },
    tipo: {
        type: DataTypes.ENUM('INDOOR', 'OUTDOOR'),
        allowNull: false,
    },
    precio_hora: {
        type: DataTypes.DECIMAL(7,2),
        allowNull: false,
    },
},
{
sequelize,
tableName: 'pistas',
timestamps: false
}
);
export default Pista;