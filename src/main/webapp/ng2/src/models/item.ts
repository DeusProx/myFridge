export class Item {
    constructor(
        public id:number,
        public name:string,
        public bbd: string,
        public description: string,
        public owner: string,
        public ingredients: string,
        public nutritions: Nutritions
    ){}
}

export class Nutritions {
    constructor(
        public kcal:number,
        public protein:number,
        public fat:number,
        public carbohydrates:number
    ){}
}