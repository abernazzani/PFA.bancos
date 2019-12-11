import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ApiBaseService } from './api-base.service';
import { Juez } from '../../models/juez';

@Injectable({ providedIn: 'root' })
export class JuecesService {

    constructor(private apiService: ApiBaseService) {

    }

    async getAll(): Promise<Juez[]> {
        return await this.apiService.get<Juez[]>("/juez/traerTodos");
    }

    async getPorCodigo(codigo: string): Promise<Juez> {
        let jueces = await this.getAll();
        return jueces.find(x => codigo == x.codigo);
    }
    
    async create(juez: Juez) {
        return await this.apiService.post("/juez/crearjuez", juez);
    }

    async delete(codigo: string) {
        return await this.apiService.delete(`/juez/eliminarPorId/${codigo}`);
    }


}