import { Component } from "react";

class Product extends Component{
    render(){
        return(
            <div className="card m-3" style={{width: "20rem"}}>
                <div className="card-header bg-primary text-white">
                    <h4>{this.props.pname}</h4>
                </div>

                <div className="card-body">
                    <p><strong>Price : </strong>{this.props.price}</p>
                    <p><strong>Brand : </strong>{this.props.brand}</p>
                    <p><strong>Rating : </strong>{this.props.rating}</p>
                    <p><strong>Stock : </strong>{this.props.stock}</p>
                </div>
            </div>
        );
    }
}
export default Product;