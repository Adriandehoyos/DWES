import { DataTypes, Model } from "sequelize";
import sequelize from "../config/database";
import Antiequipo from "./Antiequipos";


class Villano extends Model {
    public id!: number;
    public nombre!: string;
    public antiequipo_id!: number;
}

Villano.init(
    {
    id: {
        type: DataTypes.INTEGER,
        autoIncrement: true,
        primaryKey: true,
    },
    nombre: {
        type: DataTypes.STRING,
        allowNull: false,
    },
    antiequipo_id: {
        type: DataTypes.INTEGER,
        allowNull: false,
        references: {
            model: Antiequipo,
            key: 'id'
        }
    },
},  
    {
    sequelize,
    tableName: 'villanos',
    timestamps: false
}
);
Villano.belongsTo(Antiequipo, { foreignKey: 'antiequipo_id' });
export default Villano