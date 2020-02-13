import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ApiBaseService } from './api-base.service';
import { Delincuente } from '../../models/delincuente';

@Injectable({ providedIn: 'root' })
export class DelincuentesService {
    constructor(private apiBase: ApiBaseService) { }

    getAll() {
        return this.apiBase.get<Delincuente[]>('delincuentes');
    }

    async getByCode(codigo: string) {
        return await this.apiBase.get<Delincuente>(`delincuentes/${codigo}`);
    }

    async getDelincuentesPorAsalto(asaltoId: number) {
        return await this.apiBase.get<Delincuente[]>(`delincuentes/asalto/${asaltoId}`);
    }

    async create(delincuente: Delincuente) {
        return await this.apiBase.post(`delincuentes`, delincuente);
    }

    async update(delincuente: Delincuente) {
        console.log(delincuente);
        return await this.apiBase.put(`delincuentes`, delincuente);
    }

    async delete(codigo: string) {
        return await this.apiBase.delete(`delincuentes/${codigo}`);
    }
}