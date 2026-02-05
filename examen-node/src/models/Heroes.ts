import { DataTypes, Model } from "sequelize";
import sequelize from "../config/database";
import Equipo from "./Equipos";

class Heroe extends Model {
    public id!: number;
    public nombre!: string;
    public equipo_id!: number;
}

Heroe.init(
    {
    id: {
        type: DataTypes.INTEGER,
        autoIncrement: true,
        primaryKey: true,
    },
        equipo_id: {
        type: DataTypes.INTEGER,
        allowNull: false,
        references: {
            model: Equipo,
            key: 'id'
        }
    },
    nombre: {
        type: DataTypes.STRING,
        allowNull: false,
    },

},  
    {
    sequelize,
    tableName: 'heroes',
    timestamps: false
}
);
Heroe.belongsTo(Equipo, { foreignKey: 'equipo_id' });
export default Heroe