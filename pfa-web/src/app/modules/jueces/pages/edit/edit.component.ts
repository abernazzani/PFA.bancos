import { Component, OnInit, Input } from '@angular/core';
import { Banda } from 'src/app/core/models/banda';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ActivatedRoute } from '@angular/router';
import { ModalResult } from 'src/app/shared/extensions/ModalResult';
import { Location } from '@angular/common';
import { Juez } from 'src/app/core/models/juez';
import { JuecesService } from 'src/app/core/services/api/jueces.service';

@Component({
    selector: 'bandas-edit',
    templateUrl: 'edit.component.html'
})

export class JuecesEditComponent implements OnInit {
    loading: boolean;

    @Input()
    codigo: string;

    protected juez: Juez;

    constructor(private juezService: JuecesService,
        private location: Location,
        public activeModal: NgbActiveModal,
        private ngbModalService: NgbModal,
        private activatedRoute: ActivatedRoute) { }

    async ngOnInit() {
        await this.activatedRoute.params.subscribe(async params => {
            this.codigo = this.codigo || params["id"];
            debugger;
            if (this.codigo) {
                this.juez = await this.juezService.getPorCodigo(this.codigo);
            } else {
                this.juez = new Juez();
            }
        });

    }

    async save() {
        await this.juezService.create(this.juez);
        this.activeModal.close(ModalResult.Ok);
    }

    cancel() {
        if (this.ngbModalService.hasOpenModals()) {
            this.activeModal.close(ModalResult.Cancel);
        } else {
            this.location.back();
        }
    }
}