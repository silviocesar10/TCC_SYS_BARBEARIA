import mongoose from "mongoose";
const { Schema } = mongoose;
const PedidoSchema = new Schema(
	{
		usuario:{ type: Schema.Types.ObjectId, ref: "Usuario"},
		servico:{ type: Schema.Types.ObjectId, ref: "Servico"}
		dataPedido: {
			type: Date,
			required: true,
		}
	},
	{ timestamps: true }
);
export default mongoose.model("Pedido", PedidoSchema);