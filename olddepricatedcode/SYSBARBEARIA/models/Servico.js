import mongoose from "mongoose";
const { Schema } = mongoose;
const ServicoSchema = new Schema(
	{
		empresa :{ type: Schema.Types.ObjectId, ref: "Empresa"},
		nome_prod_serv:{
				type: String,
            	required: true,
            	trim: true,
		},
		descricao:{
				type: String,
            	required: true,
            	trim: true,
			},
		preco:{
				type: Number,
		        required: true,
		},
		tempo_estimado:{
				type: Number,
		        required: true,
		}
		
	}
);
export default mongoose.model("Servico", ServicoSchema);